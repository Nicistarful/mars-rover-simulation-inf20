package Interfaces;

import CameraEquipment.Picture;

public interface ICamera {
    void zoomIn();
    void zoomOut();
    Picture takePicture();
}
