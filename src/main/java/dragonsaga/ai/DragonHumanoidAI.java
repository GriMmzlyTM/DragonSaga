package dragonsaga.ai;

import dragonsaga.mobs.human.MartialArtistMob;
import necesse.engine.util.gameAreaSearch.GameAreaStream;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.ai.behaviourTree.composites.SelectorAINode;
import necesse.entity.mobs.ai.behaviourTree.leaves.TargetFinderAINode;
import necesse.entity.mobs.ai.behaviourTree.leaves.WandererAINode;
import necesse.entity.mobs.ai.behaviourTree.trees.PlayerChaserAI;
import necesse.entity.mobs.ai.behaviourTree.util.TargetFinderDistance;

import java.awt.*;

public class DragonHumanoidAI<T extends MartialArtistMob> extends PlayerChaserAI<T> {

    public DragonHumanoidAI(int searchDistance, int shootDistance, boolean smartPositioning, boolean changePositionOnHit, int wanderFrequency) {
        super(searchDistance, shootDistance, smartPositioning, changePositionOnHit);
        //addChild(new WandererAINode<T>(wanderFrequency));
    }

    @Override
    public GameAreaStream<Mob> streamPossibleTargets(T mob, Point base, TargetFinderDistance<T> distance) {
        return TargetFinderAINode.streamPlayersAndHumans(mob, base, distance);
    }

    @Override
    public boolean shootTarget(T t, Mob mob) {
        return false;
    }
}
