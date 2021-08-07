import Builders.CameraBuilder;
import Builders.MarsRoverBuilder;
import CameraEquipment.*;
import Enums.SortingOrder;
import Environment.MarsSurface;
import Rover.*;
import Utility.BatteryManagement;
import Utility.ConsoleLogger;
import Utility.MovementManagement;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        MarsSurface.init();

        MarsRoverBuilder mrb = new MarsRoverBuilder();
        ArrayList<Battery> batteries = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            batteries.add(new Battery());
        }
        mrb.setBatteries(batteries);
        mrb.setBatteryManagement(new BatteryManagement(batteries));

        mrb.setChassis(new Chassis(mrb.getBatteryManagement()));
        MovementManagement mm = new MovementManagement(mrb.getChassis().getSuspensions());
        mrb.setMovementManagement(mm);

        CameraBuilder cb = new CameraBuilder();
        cb.setLens(new Lens());
        ArrayList<Filter> filters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            filters.add(new Filter());
        }
        cb.setFilters(filters);
        cb.setMemoryCard(new MemoryCard());
        ArrayList<IRLED> irleds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            irleds.add(new IRLED());
        }
        cb.setIrleds(irleds);
        ArrayList<Chip> chips = new ArrayList<>();
        chips.add(new Chip());
        chips.add(new Chip());
        cb.setChips(chips);

        mrb.setCamera(cb.createCamera());
        ArrayList<SolarPanel> solarPanels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            solarPanels.add(new SolarPanel(mrb.getBatteryManagement()));
        }
        mrb.setSolarPanels(solarPanels);
        mrb.setGripper(new Gripper());

        MarsRover rover = mrb.createMarsRover();
        rover.getCamera().setRover(rover);

        ConsoleLogger.log(rover.getCurrentPosition());
        ConsoleLogger.log("Current power level: %s".formatted(rover.getBatteryManagement().getPowerLevel()));
        rover.getCamera().setCurrentFactor(0);

        for (int i = 0; i < 3; i++) {
            rover.getMovementManagement().moveUp();
            rover.getCamera().takePicture();
        }

        rover.getCamera().setCurrentFactor(1);

        for (int i = 0; i < 10; i++) {
            rover.getMovementManagement().turnLeft();
            rover.getCamera().takePicture();
        }

        for (int i = 0; i < 3; i++) {
            rover.getMovementManagement().turnRight();
            rover.getCamera().takePicture();
        }

        rover.getMovementManagement().moveDown();
        rover.getCamera().setCurrentFactor(2);
        rover.getCamera().takePicture();

        for (int i = 0; i < 5; i++) {
            rover.getMovementManagement().turnLeft();
            rover.extractSample();
        }

        rover.exportPicturesToCSV(SortingOrder.DESCENDING);
    }
}
