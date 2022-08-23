package net.coreprotect.paper;

import org.bukkit.Server;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface PaperInterface {

    public Object getReputation(Villager villager);

    public void setReputation(Villager villager, Object reputations);

    public InventoryHolder getHolder(Inventory holder, boolean useSnapshot);

    public boolean isStopping(Server server);

}
