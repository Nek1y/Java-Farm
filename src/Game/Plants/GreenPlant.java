package Game.Plants;

import Core.ResourceManager;

public class GreenPlant extends Plant {
    private int scoreAm = 10;
    private int successTime = 250;

    @Override
    public int getScoreAm() {
        return scoreAm;
    }

    @Override
    public int getSuccessTime() {
        return successTime;
    }

    @Override
    public byte getUI() {
        return ResourceManager.PLANT_GREEN;
    }

    @Override
    public byte getPicPrepared() {
        return ResourceManager.GARDEN_PLANT_GREEN;
    }

    @Override
    public byte getPicProcessed() {
        return ResourceManager.GARDEN_WATER_GREEN;
    }

    @Override
    public byte getPicFinished() {
        return ResourceManager.GARDEN_READY_GREEN;
    }
}
