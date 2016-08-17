package com.mrcrayfish.device.api.app;

import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.core.Laptop;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public abstract class Component extends Gui
{
	public static final ResourceLocation COMPONENTS_GUI = new ResourceLocation("cdm:textures/gui/components.png");
	
	private Application parent;
	
	public int xPosition, yPosition;
	protected int left;
	protected int top;
	
	public boolean enabled = true;
	public boolean visible = true;
	
	public Component(int x, int y, int left, int top) 
	{
		this.xPosition = x + left;
		this.yPosition = y + top;
		this.left = left;
		this.top = top;
	}
	
	public void init(Layout layout) {}
	
	public void handleTick() {}

	public abstract void render(Laptop laptop, Minecraft mc, int mouseX, int mouseY, boolean windowActive, float partialTicks);
	
	public void renderOverlay(Laptop laptop, Minecraft mc, int mouseX, int mouseY, boolean windowActive) {}
	
	public void handleButtonClick(Button button) {}
	
	public void handleClick(int mouseX, int mouseY, int mouseButton) {}
	
	public void handleKeyTyped(char character, int code) {}
	
	public void handleDrag(int mouseX, int mouseY, int mouseButton) {}
	
	public void handleRelease(int mouseX, int mouseY, int mouseButton) {}
	
	public final void updateComponents(int x, int y) 
	{
		this.xPosition = x + left;
		this.yPosition = y + top;
	}
	
	public final void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
	}
	
	public final void setVisible(boolean visible)
	{
		this.visible = visible;
	}
}
