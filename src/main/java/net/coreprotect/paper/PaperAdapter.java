package net.coreprotect.paper;

import org.bukkit.Server;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import net.coreprotect.bukkit.BukkitAdapter;
import net.coreprotect.config.ConfigHandler;

public class PaperAdapter implements PaperInterface {

    public static PaperInterface ADAPTER;
    public static final int PAPER_UNAVAILABLE = 0;
    public static final int PAPER_V1_13 = BukkitAdapter.BUKKIT_V1_13;
    public static final int PAPER_V1_14 = BukkitAdapter.BUKKIT_V1_14;
    public static final int PAPER_V1_15 = BukkitAdapter.BUKKIT_V1_15;
    public static final int PAPER_V1_16 = BukkitAdapter.BUKKIT_V1_16;
    public static final int PAPER_V1_17 = BukkitAdapter.BUKKIT_V1_17;
    public static final int PAPER_V1_18 = BukkitAdapter.BUKKIT_V1_18;
    public static final int PAPER_V1_19 = BukkitAdapter.BUKKIT_V1_19;

    public static void loadAdapter() {
        int paperVersion = ConfigHandler.SERVER_VERSION;
        if (!ConfigHandler.isPaper) {
            paperVersion = PAPER_UNAVAILABLE;
        }

        switch (paperVersion) {
            case PAPER_UNAVAILABLE:
                PaperAdapter.ADAPTER = new PaperAdapter();
                break;
            case PAPER_V1_13:
            case PAPER_V1_14:
                PaperAdapter.ADAPTER = new PaperHandler();
            case PAPER_V1_15:
                PaperAdapter.ADAPTER = new Paper_v1_15();
                break;
            case PAPER_V1_16:
            case PAPER_V1_17:
            case PAPER_V1_18:
            case PAPER_V1_19:
            default:
                PaperAdapter.ADAPTER = new Paper_v1_16();
                break;
        }
    }

    @Override
    public Object getReputation(Villager villager) {
        return null;
    }

    @Override
    public void setReputation(Villager villager, Object reputations) {
    }

    @Override
    public InventoryHolder getHolder(Inventory holder, boolean useSnapshot) {
        return holder.getHolder();
    }

    @Override
    public boolean isStopping(Server server) {
        return false;
    }

}
