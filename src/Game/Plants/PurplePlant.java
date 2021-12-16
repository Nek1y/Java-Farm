package Game.Plants;

import Core.ResourceManager;

public class PurplePlant extends Plant {
    private int scoreAm = 250;
    private int successTime = 1000;

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
        return ResourceManager.PLANT_PURPLE;
    }

    @Override
    public byte getPicPrepared() {
        return ResourceManager.GARDEN_PLANT_PURPLE;
    }

    @Override
    public byte getPicProcessed() {
        return ResourceManager.GARDEN_WATER_PURPLE;
    }

    @Override
    public byte getPicFinished() {
        return ResourceManager.GARDEN_READY_PURPLE;
    }
}
