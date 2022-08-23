package net.coreprotect.utility.serialize;

import com.destroystokyo.paper.entity.villager.Reputation;
import com.destroystokyo.paper.entity.villager.ReputationType;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;

public class ReputationSerializeable implements Serializable {

    @NotNull
    private final int[] reputation;

    public ReputationSerializeable(Reputation paperReputation) {
        reputation = new int[ReputationType.values().length];
        for(ReputationType repType : ReputationType.values()) {
            reputation[repType.ordinal()] = paperReputation.getReputation(repType);
        }
    }

    public Reputation getReputation() {
        HashMap<ReputationType, Integer> repMap = new HashMap<>();
        for(ReputationType repType : ReputationType.values()) {
            repMap.put(repType, reputation[repType.ordinal()]);
        }

        return new Reputation(repMap);
    }
}
