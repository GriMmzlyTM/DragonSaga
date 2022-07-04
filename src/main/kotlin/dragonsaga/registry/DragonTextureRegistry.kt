package dragonsaga.registry

import necesse.entity.mobs.HumanTexture
import necesse.gfx.gameTexture.GameTexture

object Textures {
    var MARTIAL_ARTIST_BASE: HumanTexture? = null
}

object DragonTextureRegistry {
    fun RegisterAll() {
        Textures.MARTIAL_ARTIST_BASE = HumanTexture(
            GameTexture.fromFile("mobs/martial_artist/MartialArtistBase"),
            GameTexture.fromFile("mobs/martial_artist/MartialArtistBase_LeftArm"),
            GameTexture.fromFile("mobs/martial_artist/MartialArtistBase_RightArm")
        )
    }
}