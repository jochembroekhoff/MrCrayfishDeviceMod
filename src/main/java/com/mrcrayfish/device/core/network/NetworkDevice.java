package com.mrcrayfish.device.core.network;

import com.mrcrayfish.device.tileentity.TileEntityDevice;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public class NetworkDevice
{
    private Router router;
    private UUID id;
    private String name;
    private BlockPos pos;

    private NetworkDevice() {}

    public NetworkDevice(TileEntityDevice device, Router router)
    {
        this.router = router;
        this.id = device.getId();
        update(device);
    }

    public UUID getUUID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    @Nullable
    public BlockPos getPos()
    {
        return pos;
    }

    public boolean isConnected(World world)
    {
        if(pos == null)
            return false;

        TileEntity tileEntity = world.getTileEntity(pos);
        if(tileEntity instanceof TileEntityDevice)
        {
            TileEntityDevice device = (TileEntityDevice) tileEntity;
            Router router = device.getRouter();
            return router != null && router.getId().equals(router.getId());
        }
        return false;
    }

    public void update(TileEntityDevice device)
    {
        name = device.getDeviceName();
        pos = device.getPos();
    }

    public NBTTagCompound toTag()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("id", id.toString());
        tag.setString("name", name);
        return tag;
    }

    public static NetworkDevice fromTag(NBTTagCompound tag)
    {
        NetworkDevice device = new NetworkDevice();
        device.id = UUID.fromString(tag.getString("id"));
        device.name = tag.getString("name");
        return device;
    }
}