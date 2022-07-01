package dragonsaga.mobs.human;

import dragonsaga.database.DragonMobDatabase;
import necesse.engine.tickManager.TickManager;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.PlayerChaserWandererAI;
import necesse.entity.mobs.hostile.HostileMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

import java.awt.*;
import java.util.List;

public abstract class MartialArtistMob extends HostileMob {

    private Point _baseTile;

    public MartialArtistMob(int health) {
        super(health);
        setSpeed(40f);
        setFriction(1f);
        setArmor(20);
        collision = new Rectangle(-10, -7, 20, 14);
        hitBox = new Rectangle(-14, -12, 28, 24);
        selectBox = new Rectangle(-14, -41, 28, 48);
        canDespawn = false;
        _baseTile = null;
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        for(int i = 0; i < 4; ++i) {
            this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), DragonMobDatabase.Textures.MartialArtistBase.body, GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC);
        }
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        Point sprite = this.getAnimSprite(x, y, this.dir);
        drawY += this.getBobbing(x, y);
        drawY += this.getLevel().getTile(x / 32, y / 32).getMobSinkingAmount(this);
        HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(DragonMobDatabase.Textures.MartialArtistBase)).sprite(sprite).dir(this.dir).light(light);

        if (this.inLiquid(x, y)) {
            drawY -= 10;
            humanDrawOptions.armSprite(2);
        }


        final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                drawOptions.draw();
            }
        });

        this.addShadowDrawables(tileList, x, y, light, camera);
    }

    protected void addAttackDraw(HumanDrawOptions drawOptions, float attackProgress) {
        this.addMeleeAttackDraw(drawOptions, attackProgress);
    }

    protected void addMeleeAttackDraw(HumanDrawOptions drawOptions, float attackProgress) {
        drawOptions.itemAttack(new InventoryItem("nunchucks"), null, attackProgress, this.attackDir.x, this.attackDir.y);
    }

    public void setupAI() {
        //ai = new BehaviourTreeAI(this, new DragonHumanoidAI(640, 50, true, true, 60000));
        this.ai = new BehaviourTreeAI(this, new PlayerChaserWandererAI<MartialArtistMob>(null, 200, 0, 10000, true, true) {
            @Override
            public boolean shootTarget(MartialArtistMob martialArtistMob, Mob mob) {
                return false;
            }
        });
//        ai = new BehaviourTreeAI(this, new CollisionPlayerChaserWandererAI(() -> {
//            return !this.getLevel().isCave && !this.getLevel().getServer().world.worldEntity.isNight();
//        }, 450, new GameDamage(16.0F), 50, 60000));
    }

    public void init() {
        super.init();
        this.setupAI();
    }
}
