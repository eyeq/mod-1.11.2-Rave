package eyeq.rave.event;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RaveEventHandler {
    @SubscribeEvent
    public void onRenderLivingPre(RenderLivingEvent.Pre event) {
        RenderLivingBase render = event.getRenderer();
        ModelBase model = render.getMainModel();
        if(model instanceof ModelBiped) {
            EntityLivingBase entity = event.getEntity();
            long now = System.currentTimeMillis() + entity.getUniqueID().hashCode();
            float t = (now % 360) * (float) Math.PI / 180;

            ((ModelBiped) model).bipedHead.rotateAngleZ = MathHelper.sin(t - (float) Math.PI / 8) / 4;
            event.getEntity().swingProgress = MathHelper.sin(t / 10);
        }
    }
}
