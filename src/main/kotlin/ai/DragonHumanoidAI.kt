package ai

import dragonsaga.mobs.MartialArtistMob
import necesse.engine.util.gameAreaSearch.GameAreaStream
import necesse.entity.mobs.Mob
import necesse.entity.mobs.ai.behaviourTree.leaves.TargetFinderAINode
import necesse.entity.mobs.ai.behaviourTree.trees.PlayerChaserAI
import necesse.entity.mobs.ai.behaviourTree.util.TargetFinderDistance
import java.awt.Point

class DragonHumanoidAI<T : MartialArtistMob?>(
    searchDistance: Int,
    shootDistance: Int,
    smartPositioning: Boolean,
    changePositionOnHit: Boolean,
    wanderFrequency: Int
) : PlayerChaserAI<T>(searchDistance, shootDistance, smartPositioning, changePositionOnHit) {
    override fun streamPossibleTargets(mob: T, base: Point, distance: TargetFinderDistance<T>): GameAreaStream<Mob> {
        return TargetFinderAINode.streamPlayersAndHumans(mob, base, distance)
    }

    override fun shootTarget(t: T, mob: Mob): Boolean {
        return false
    }
}