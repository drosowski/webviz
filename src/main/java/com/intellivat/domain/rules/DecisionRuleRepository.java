package com.intellivat.domain.rules;

import java.util.Collection;

/**
 * Repository used to store and retrieve {@link DecisionRule}s.
 *
 * @author Daniel Rosowski
 */
public interface DecisionRuleRepository {

    /**
     * @param id
     * @return the decisionRule with the given {@code id}.
     */
    DecisionRule getRuleFor(String id);

    /**
     * Stores the given {@code rule} in the repository.
     *
     * @param rule
     */
    void storeRule(DecisionRule rule);

    /**
     *
     * @return all {@link DecisionRule} from the repository.
     */
    Collection<DecisionRule> listRules();
}
