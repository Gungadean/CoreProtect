package net.coreprotect.paper;

import net.coreprotect.utility.serialize.ReputationSerializeable;
import org.bukkit.entity.Villager;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Paper_v1_15 extends PaperHandler implements PaperInterface {

    @Override
    public Object getReputation(Villager villager) {
        return villager.getReputations().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new ReputationSerializeable(entry.getValue())));
    }

    @Override
    public void setReputation(Villager villager, Object reputations) {
        villager.setReputations(((Map<UUID, ReputationSerializeable>)reputations).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getReputation())));
    }
}
