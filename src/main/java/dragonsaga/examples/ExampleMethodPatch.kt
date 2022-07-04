package dragonsaga.examples

import necesse.engine.modLoader.annotations.ModMethodPatch
import necesse.entity.projectile.IronBombProjectile

/**
 * The game uses Byte Buddy to allow mods to make patches inside the source code.
 * The class you assign as a mod patch acts as the advice class in Byte Buddy.
 * Use @ModMethodPatch to define which class and method to apply the patch to.
 * Define an optional priority if you want some patch to happen before another (higher priority means happens first)
 *
 * You can read the official documentation here:
 * [...](https://javadoc.io/doc/net.bytebuddy/byte-buddy/1.12.8/net/bytebuddy/asm/Advice.html)
 *
 * I have written a brief overview of some of the most important annotations:
 *
 * "@Advice.OnMethodEnter" - The annotated method happens when we enter the method, before the methods
 * content is run.
 * Combine this with onSkip = Advice.OnNonDefaultValue.class and return true to skip the original
 * method's execution. Make sure the annotated method returns something for this to work. See the example below.
 * If you do not plan to ever skip the original method, the annotated OnMethodEnter method
 * does not have to return anything (it can be a void method).
 *
 * "@Advice.OnMethodExit" - The annotate method happens when we exit the method, after the method has
 * returned what it should.
 * This returned object can be overridden using the "@Advice.Return(readOnly = false)" for a parameter
 *
 * "@Advice.This" - The annotated parameter is mapped to the object running, similar to "this" in java.
 *
 * "@Advice.FieldValue" - The annotated parameter is mapped to a field in the scope of the method.
 * This could for example be a private field, or something similar.
 * Setting "readOnly = false" on this indicates being able to write a value to the field.
 *
 * "@Advice.AllArguments" - The annotated parameter is assigned all arguments passed into the target method.
 * This annotated parameter must be an array type
 *
 * "@Advice.Argument(n)" - The annotated parameter is mapped to the n argument passed into the target method.
 */
@ModMethodPatch(
    target = IronBombProjectile::class,
    name = "getExplosionEvent",
    arguments = [Float::class, Float::class]
)
class ExampleMethodPatch { //    @Advice.OnMethodExit
    //    static void onExit(@Advice.This IronBombProjectile bomb, @Advice.Argument(0) float x, @Advice.Argument(1) float y, @Advice.Return(readOnly = false) ExplosionEvent explosionEvent) {
    //        explosionEvent = new BombExplosionEvent(x, y, 300, new GameDamage(200f, 1000f), true, 1, bomb.getOwner());
    //    }
}