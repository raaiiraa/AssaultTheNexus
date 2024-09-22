package com.gmail.lynx7478.anni.anniGame.autoRespawn.versions;
import org.bukkit.entity.Player;

import com.gmail.lynx7478.anni.anniGame.autoRespawn.RespawnPacket;


public class v1_13_R2Packet implements RespawnPacket
{

	@Override
	public void sendToPlayer(Player player) 
	{
		return;
	}
    /*private final PacketPlayInClientCommand packet;
    public v1_13_R2Packet()
    {
        packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
    }

    @Override
    public void sendToPlayer(final Player player)
    {
        CraftPlayer p = (CraftPlayer)player;
        p.getHandle().playerConnection.a(packet);
    } */
}
