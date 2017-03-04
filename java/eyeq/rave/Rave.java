package eyeq.rave;

import eyeq.rave.event.RaveEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.rave.Rave.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class Rave {
    public static final String MOD_ID = "eyeq_rave";

    @Mod.Instance(MOD_ID)
    public static Rave instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RaveEventHandler());
    }
}
