package com.intellivat.domain.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A fake implementation of {@code DecisionRuleRepository} using a Map as the
 * backing storage.
 *
 * @author Daniel Rosowski
 */
public class MapDecisionRuleRepository
        implements DecisionRuleRepository {

    private Map<String, DecisionRule> ruleMap = new HashMap<>();

    @Override
    public DecisionRule getRuleFor(String id) {
        return ruleMap.get(id);
    }

    @Override
    public void storeRule(DecisionRule rule) {
        ruleMap.put(rule.getId(), rule);
    }

    @Override
    public Collection<DecisionRule> listRules() {
        return new ArrayList<DecisionRule>(ruleMap.values());
    }

}
