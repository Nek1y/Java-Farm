package Game.Plants;

import Core.ResourceManager;

public class BluePlant extends Plant {
    private int scoreAm = 50;
    private int successTime = 500;
    
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
        return ResourceManager.PLANT_BLUE;
    }

    @Override
    public byte getPicPrepared() {
        return ResourceManager.GARDEN_PLANT_BLUE;
    }

    @Override
    public byte getPicProcessed() {
        return ResourceManager.GARDEN_WATER_BLUE;
    }

    @Override
    public byte getPicFinished() {
        return ResourceManager.GARDEN_READY_BLUE;
    }
}
