package com.teamderpy.shouldersurfing;


import com.teamderpy.shouldersurfing.math.RayTracer;
import com.teamderpy.shouldersurfing.renderer.ShoulderRenderBin;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Type;
import net.minecraftforge.fml.relauncher.Side;


public class ShoulderTickHandler {
		
	@SubscribeEvent
	public void renderTickStart(RenderTickEvent event) {
		if((event.side==Side.CLIENT)&&(event.phase==Phase.START)&&(event.type==Type.RENDER)){
			ShoulderRenderBin.skipPlayerRender = false;
			
			//attempt to ray trace
			RayTracer.traceFromEyes(1.0F);
			
			if(ShoulderRenderBin.rayTraceHit != null){
				if(ShoulderLoader.mc.player != null){
					//calculate the difference
					double x = ShoulderLoader.mc.player.posX;
					double y = ShoulderLoader.mc.player.posY;
					double z = ShoulderLoader.mc.player.posZ;
					ShoulderRenderBin.rayTraceHit = ShoulderRenderBin.rayTraceHit.addVector(-x,-y,-z);
				}
			}
			
		}
	}
}
