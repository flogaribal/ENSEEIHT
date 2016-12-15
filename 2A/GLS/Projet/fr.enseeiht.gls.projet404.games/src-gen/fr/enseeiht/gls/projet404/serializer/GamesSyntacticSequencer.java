/*
 * generated by Xtext 2.10.0
 */
package fr.enseeiht.gls.projet404.serializer;

import com.google.inject.Inject;
import fr.enseeiht.gls.projet404.services.GamesGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class GamesSyntacticSequencer extends AbstractSyntacticSequencer {

	protected GamesGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Action_ConditionsActionsAvailableKeyword_10_0_q;
	protected AbstractElementAlias match_Action_ItemsConsumedKeyword_9_0_q;
	protected AbstractElementAlias match_Action_ItemsGivenKeyword_8_0_q;
	protected AbstractElementAlias match_Action_KnowledgeGivenKeyword_7_0_q;
	protected AbstractElementAlias match_Condition_ItemsKeyword_6_0_q;
	protected AbstractElementAlias match_Condition_KnowledgeKeyword_5_0_q;
	protected AbstractElementAlias match_Difficulty_KnowledgeKeyword_6_0_q;
	protected AbstractElementAlias match_Interaction_ConditionsBeginKeyword_7_0_q;
	protected AbstractElementAlias match_Interaction_ConditionsEndKeyword_8_0_q;
	protected AbstractElementAlias match_Item_ConditionsConsumedKeyword_18_0_q;
	protected AbstractElementAlias match_Item_ConditionsGiveKeyword_17_0_q;
	protected AbstractElementAlias match_Item_ConditionsPutDownKeyword_16_0_q;
	protected AbstractElementAlias match_Item_ConditionsVisibleKeyword_9_0_q;
	protected AbstractElementAlias match_Knowledge_ConditionsActiveKeyword_10_0_q;
	protected AbstractElementAlias match_Knowledge_ConditionsGiveKeyword_11_0_q;
	protected AbstractElementAlias match_Knowledge_ConditionsVisibleKeyword_7_0_q;
	protected AbstractElementAlias match_Path_ConditionsOpenKeyword_12_0_q;
	protected AbstractElementAlias match_Path_ConditionsVisibleKeyword_7_0_q;
	protected AbstractElementAlias match_Path_ItemsConsumedKeyword_17_0_q;
	protected AbstractElementAlias match_Path_ItemsGivenKeyword_16_0_q;
	protected AbstractElementAlias match_Path_KnowledgesGivenKeyword_15_0_q;
	protected AbstractElementAlias match_People_ConditionsActiveKeyword_10_0_q;
	protected AbstractElementAlias match_People_ConditionsVisibleKeyword_7_0_q;
	protected AbstractElementAlias match_Place_ItemsKeyword_6_0_q;
	protected AbstractElementAlias match_Place_KnowledgeKeyword_3_0_q;
	protected AbstractElementAlias match_Place_PathsKeyword_5_0_q;
	protected AbstractElementAlias match_Place_PeopleKeyword_4_0_q;
	protected AbstractElementAlias match_Player_ItemsKeyword_3_0_q;
	protected AbstractElementAlias match_Player_KnowledgeKeyword_4_0_q;
	protected AbstractElementAlias match_Recipe_ConditionsKeyword_5_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GamesGrammarAccess) access;
		match_Action_ConditionsActionsAvailableKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getActionAccess().getConditionsActionsAvailableKeyword_10_0());
		match_Action_ItemsConsumedKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getActionAccess().getItemsConsumedKeyword_9_0());
		match_Action_ItemsGivenKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getActionAccess().getItemsGivenKeyword_8_0());
		match_Action_KnowledgeGivenKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getActionAccess().getKnowledgeGivenKeyword_7_0());
		match_Condition_ItemsKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getConditionAccess().getItemsKeyword_6_0());
		match_Condition_KnowledgeKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getConditionAccess().getKnowledgeKeyword_5_0());
		match_Difficulty_KnowledgeKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getDifficultyAccess().getKnowledgeKeyword_6_0());
		match_Interaction_ConditionsBeginKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getInteractionAccess().getConditionsBeginKeyword_7_0());
		match_Interaction_ConditionsEndKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getInteractionAccess().getConditionsEndKeyword_8_0());
		match_Item_ConditionsConsumedKeyword_18_0_q = new TokenAlias(false, true, grammarAccess.getItemAccess().getConditionsConsumedKeyword_18_0());
		match_Item_ConditionsGiveKeyword_17_0_q = new TokenAlias(false, true, grammarAccess.getItemAccess().getConditionsGiveKeyword_17_0());
		match_Item_ConditionsPutDownKeyword_16_0_q = new TokenAlias(false, true, grammarAccess.getItemAccess().getConditionsPutDownKeyword_16_0());
		match_Item_ConditionsVisibleKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getItemAccess().getConditionsVisibleKeyword_9_0());
		match_Knowledge_ConditionsActiveKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getKnowledgeAccess().getConditionsActiveKeyword_10_0());
		match_Knowledge_ConditionsGiveKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getKnowledgeAccess().getConditionsGiveKeyword_11_0());
		match_Knowledge_ConditionsVisibleKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getKnowledgeAccess().getConditionsVisibleKeyword_7_0());
		match_Path_ConditionsOpenKeyword_12_0_q = new TokenAlias(false, true, grammarAccess.getPathAccess().getConditionsOpenKeyword_12_0());
		match_Path_ConditionsVisibleKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getPathAccess().getConditionsVisibleKeyword_7_0());
		match_Path_ItemsConsumedKeyword_17_0_q = new TokenAlias(false, true, grammarAccess.getPathAccess().getItemsConsumedKeyword_17_0());
		match_Path_ItemsGivenKeyword_16_0_q = new TokenAlias(false, true, grammarAccess.getPathAccess().getItemsGivenKeyword_16_0());
		match_Path_KnowledgesGivenKeyword_15_0_q = new TokenAlias(false, true, grammarAccess.getPathAccess().getKnowledgesGivenKeyword_15_0());
		match_People_ConditionsActiveKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getPeopleAccess().getConditionsActiveKeyword_10_0());
		match_People_ConditionsVisibleKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getPeopleAccess().getConditionsVisibleKeyword_7_0());
		match_Place_ItemsKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getPlaceAccess().getItemsKeyword_6_0());
		match_Place_KnowledgeKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getPlaceAccess().getKnowledgeKeyword_3_0());
		match_Place_PathsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getPlaceAccess().getPathsKeyword_5_0());
		match_Place_PeopleKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getPlaceAccess().getPeopleKeyword_4_0());
		match_Player_ItemsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getPlayerAccess().getItemsKeyword_3_0());
		match_Player_KnowledgeKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getPlayerAccess().getKnowledgeKeyword_4_0());
		match_Recipe_ConditionsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getRecipeAccess().getConditionsKeyword_5_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Action_ConditionsActionsAvailableKeyword_10_0_q.equals(syntax))
				emit_Action_ConditionsActionsAvailableKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Action_ItemsConsumedKeyword_9_0_q.equals(syntax))
				emit_Action_ItemsConsumedKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Action_ItemsGivenKeyword_8_0_q.equals(syntax))
				emit_Action_ItemsGivenKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Action_KnowledgeGivenKeyword_7_0_q.equals(syntax))
				emit_Action_KnowledgeGivenKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Condition_ItemsKeyword_6_0_q.equals(syntax))
				emit_Condition_ItemsKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Condition_KnowledgeKeyword_5_0_q.equals(syntax))
				emit_Condition_KnowledgeKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Difficulty_KnowledgeKeyword_6_0_q.equals(syntax))
				emit_Difficulty_KnowledgeKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Interaction_ConditionsBeginKeyword_7_0_q.equals(syntax))
				emit_Interaction_ConditionsBeginKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Interaction_ConditionsEndKeyword_8_0_q.equals(syntax))
				emit_Interaction_ConditionsEndKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Item_ConditionsConsumedKeyword_18_0_q.equals(syntax))
				emit_Item_ConditionsConsumedKeyword_18_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Item_ConditionsGiveKeyword_17_0_q.equals(syntax))
				emit_Item_ConditionsGiveKeyword_17_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Item_ConditionsPutDownKeyword_16_0_q.equals(syntax))
				emit_Item_ConditionsPutDownKeyword_16_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Item_ConditionsVisibleKeyword_9_0_q.equals(syntax))
				emit_Item_ConditionsVisibleKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Knowledge_ConditionsActiveKeyword_10_0_q.equals(syntax))
				emit_Knowledge_ConditionsActiveKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Knowledge_ConditionsGiveKeyword_11_0_q.equals(syntax))
				emit_Knowledge_ConditionsGiveKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Knowledge_ConditionsVisibleKeyword_7_0_q.equals(syntax))
				emit_Knowledge_ConditionsVisibleKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Path_ConditionsOpenKeyword_12_0_q.equals(syntax))
				emit_Path_ConditionsOpenKeyword_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Path_ConditionsVisibleKeyword_7_0_q.equals(syntax))
				emit_Path_ConditionsVisibleKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Path_ItemsConsumedKeyword_17_0_q.equals(syntax))
				emit_Path_ItemsConsumedKeyword_17_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Path_ItemsGivenKeyword_16_0_q.equals(syntax))
				emit_Path_ItemsGivenKeyword_16_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Path_KnowledgesGivenKeyword_15_0_q.equals(syntax))
				emit_Path_KnowledgesGivenKeyword_15_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_People_ConditionsActiveKeyword_10_0_q.equals(syntax))
				emit_People_ConditionsActiveKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_People_ConditionsVisibleKeyword_7_0_q.equals(syntax))
				emit_People_ConditionsVisibleKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Place_ItemsKeyword_6_0_q.equals(syntax))
				emit_Place_ItemsKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Place_KnowledgeKeyword_3_0_q.equals(syntax))
				emit_Place_KnowledgeKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Place_PathsKeyword_5_0_q.equals(syntax))
				emit_Place_PathsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Place_PeopleKeyword_4_0_q.equals(syntax))
				emit_Place_PeopleKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Player_ItemsKeyword_3_0_q.equals(syntax))
				emit_Player_ItemsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Player_KnowledgeKeyword_4_0_q.equals(syntax))
				emit_Player_KnowledgeKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Recipe_ConditionsKeyword_5_0_q.equals(syntax))
				emit_Recipe_ConditionsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'conditionsActionsAvailable'?
	 *
	 * This ambiguous syntax occurs at:
	 *     interSuivante=Interaction 'knowledgeGiven'? 'itemsGiven'? 'itemsConsumed'? (ambiguity) 'game' game=[Game|ID]
	 *     itemsConsumed+=ItemInSomething (ambiguity) 'game' game=[Game|ID]
	 *     itemsGiven+=ItemInSomething 'itemsConsumed'? (ambiguity) 'game' game=[Game|ID]
	 *     knowledgeGiven+=[Knowledge|ID] 'itemsGiven'? 'itemsConsumed'? (ambiguity) 'game' game=[Game|ID]
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? 'itemsGiven'? 'itemsConsumed'? (ambiguity) 'game' game=[Game|ID]
	 */
	protected void emit_Action_ConditionsActionsAvailableKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'itemsConsumed'?
	 *
	 * This ambiguous syntax occurs at:
	 *     interSuivante=Interaction 'knowledgeGiven'? 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     interSuivante=Interaction 'knowledgeGiven'? 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     itemsGiven+=ItemInSomething (ambiguity) 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     itemsGiven+=ItemInSomething (ambiguity) 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     knowledgeGiven+=[Knowledge|ID] 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     knowledgeGiven+=[Knowledge|ID] 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? 'itemsGiven'? (ambiguity) 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 */
	protected void emit_Action_ItemsConsumedKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'itemsGiven'?
	 *
	 * This ambiguous syntax occurs at:
	 *     interSuivante=Interaction 'knowledgeGiven'? (ambiguity) 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     interSuivante=Interaction 'knowledgeGiven'? (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     interSuivante=Interaction 'knowledgeGiven'? (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     knowledgeGiven+=[Knowledge|ID] (ambiguity) 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     knowledgeGiven+=[Knowledge|ID] (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     knowledgeGiven+=[Knowledge|ID] (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? (ambiguity) 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     val=Actions 'nextInteraction' 'knowledgeGiven'? (ambiguity) 'itemsConsumed'? 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 */
	protected void emit_Action_ItemsGivenKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledgeGiven'?
	 *
	 * This ambiguous syntax occurs at:
	 *     interSuivante=Interaction (ambiguity) 'itemsGiven' itemsGiven+=ItemInSomething
	 *     interSuivante=Interaction (ambiguity) 'itemsGiven'? 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     interSuivante=Interaction (ambiguity) 'itemsGiven'? 'itemsConsumed'? 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     interSuivante=Interaction (ambiguity) 'itemsGiven'? 'itemsConsumed'? 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 *     val=Actions 'nextInteraction' (ambiguity) 'itemsGiven' itemsGiven+=ItemInSomething
	 *     val=Actions 'nextInteraction' (ambiguity) 'itemsGiven'? 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     val=Actions 'nextInteraction' (ambiguity) 'itemsGiven'? 'itemsConsumed'? 'conditionsActionsAvailable' conditionsActionsAvailable+=Condition
	 *     val=Actions 'nextInteraction' (ambiguity) 'itemsGiven'? 'itemsConsumed'? 'conditionsActionsAvailable'? 'game' game=[Game|ID]
	 */
	protected void emit_Action_KnowledgeGivenKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'items'?
	 *
	 * This ambiguous syntax occurs at:
	 *     know+=[Knowledge|ID] (ambiguity) '}' (rule end)
	 *     player=[Player|ID] 'knowledge'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Condition_ItemsKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledge'?
	 *
	 * This ambiguous syntax occurs at:
	 *     player=[Player|ID] (ambiguity) 'items' item+=ItemInCondition
	 *     player=[Player|ID] (ambiguity) 'items'? '}' (rule end)
	 */
	protected void emit_Condition_KnowledgeKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledge'?
	 *
	 * This ambiguous syntax occurs at:
	 *     items+=ItemInSomething ']' (ambiguity) '}' (rule end)
	 *     sizeMax=INT (ambiguity) '}' (rule end)
	 */
	protected void emit_Difficulty_KnowledgeKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsBegin'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=STRING '{' 'propositions' '{' '}' (ambiguity) 'conditionsEnd' conditionsEnd+=Condition
	 *     name=STRING '{' 'propositions' '{' '}' (ambiguity) 'conditionsEnd'? '}' (rule end)
	 *     prop+=Proposition '}' (ambiguity) 'conditionsEnd' conditionsEnd+=Condition
	 *     prop+=Proposition '}' (ambiguity) 'conditionsEnd'? '}' (rule end)
	 */
	protected void emit_Interaction_ConditionsBeginKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsEnd'?
	 *
	 * This ambiguous syntax occurs at:
	 *     conditionsBegin+=Condition (ambiguity) '}' (rule end)
	 *     name=STRING '{' 'propositions' '{' '}' 'conditionsBegin'? (ambiguity) '}' (rule end)
	 *     prop+=Proposition '}' 'conditionsBegin'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Interaction_ConditionsEndKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsConsumed'?
	 *
	 * This ambiguous syntax occurs at:
	 *     canPutDown=INT 'conditionsPutDown'? 'conditionsGive'? (ambiguity) '}' (rule end)
	 *     conditionsGive+=Condition (ambiguity) '}' (rule end)
	 *     conditionsPutDown+=Condition 'conditionsGive'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Item_ConditionsConsumedKeyword_18_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsGive'?
	 *
	 * This ambiguous syntax occurs at:
	 *     canPutDown=INT 'conditionsPutDown'? (ambiguity) 'conditionsConsumed' conditionsConsumed+=Condition
	 *     canPutDown=INT 'conditionsPutDown'? (ambiguity) 'conditionsConsumed'? '}' (rule end)
	 *     conditionsPutDown+=Condition (ambiguity) 'conditionsConsumed' conditionsConsumed+=Condition
	 *     conditionsPutDown+=Condition (ambiguity) 'conditionsConsumed'? '}' (rule end)
	 */
	protected void emit_Item_ConditionsGiveKeyword_17_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsPutDown'?
	 *
	 * This ambiguous syntax occurs at:
	 *     canPutDown=INT (ambiguity) 'conditionsGive' conditionsGive+=Condition
	 *     canPutDown=INT (ambiguity) 'conditionsGive'? 'conditionsConsumed' conditionsConsumed+=Condition
	 *     canPutDown=INT (ambiguity) 'conditionsGive'? 'conditionsConsumed'? '}' (rule end)
	 */
	protected void emit_Item_ConditionsPutDownKeyword_16_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsVisible'?
	 *
	 * This ambiguous syntax occurs at:
	 *     visible=INT (ambiguity) 'active' active=INT
	 */
	protected void emit_Item_ConditionsVisibleKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsActive'?
	 *
	 * This ambiguous syntax occurs at:
	 *     active=INT (ambiguity) 'conditionsGive' conditionsGive+=Condition
	 *     active=INT (ambiguity) 'conditionsGive'? '}' (rule end)
	 */
	protected void emit_Knowledge_ConditionsActiveKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsGive'?
	 *
	 * This ambiguous syntax occurs at:
	 *     active=INT 'conditionsActive'? (ambiguity) '}' (rule end)
	 *     conditionsActive+=Condition (ambiguity) '}' (rule end)
	 */
	protected void emit_Knowledge_ConditionsGiveKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsVisible'?
	 *
	 * This ambiguous syntax occurs at:
	 *     visible=INT (ambiguity) 'active' active=INT
	 */
	protected void emit_Knowledge_ConditionsVisibleKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsOpen'?
	 *
	 * This ambiguous syntax occurs at:
	 *     isOpen=INT (ambiguity) 'isMandatory' isMandatory=INT
	 */
	protected void emit_Path_ConditionsOpenKeyword_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsVisible'?
	 *
	 * This ambiguous syntax occurs at:
	 *     visible=INT (ambiguity) 'endPlace' endPlace=[Place|ID]
	 */
	protected void emit_Path_ConditionsVisibleKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'itemsConsumed'?
	 *
	 * This ambiguous syntax occurs at:
	 *     isMandatory=INT 'knowledgesGiven'? 'itemsGiven'? (ambiguity) '}' (rule end)
	 *     itemsGiven+=ItemInSomething (ambiguity) '}' (rule end)
	 *     knowledgeGiven+=[Knowledge|ID] 'itemsGiven'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Path_ItemsConsumedKeyword_17_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'itemsGiven'?
	 *
	 * This ambiguous syntax occurs at:
	 *     isMandatory=INT 'knowledgesGiven'? (ambiguity) 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     isMandatory=INT 'knowledgesGiven'? (ambiguity) 'itemsConsumed'? '}' (rule end)
	 *     knowledgeGiven+=[Knowledge|ID] (ambiguity) 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     knowledgeGiven+=[Knowledge|ID] (ambiguity) 'itemsConsumed'? '}' (rule end)
	 */
	protected void emit_Path_ItemsGivenKeyword_16_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledgesGiven'?
	 *
	 * This ambiguous syntax occurs at:
	 *     isMandatory=INT (ambiguity) 'itemsGiven' itemsGiven+=ItemInSomething
	 *     isMandatory=INT (ambiguity) 'itemsGiven'? 'itemsConsumed' itemsConsumed+=ItemInSomething
	 *     isMandatory=INT (ambiguity) 'itemsGiven'? 'itemsConsumed'? '}' (rule end)
	 */
	protected void emit_Path_KnowledgesGivenKeyword_15_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsActive'?
	 *
	 * This ambiguous syntax occurs at:
	 *     active=INT (ambiguity) 'isMandatory' isMandatory=INT
	 */
	protected void emit_People_ConditionsActiveKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditionsVisible'?
	 *
	 * This ambiguous syntax occurs at:
	 *     visible=INT (ambiguity) 'active' active=INT
	 */
	protected void emit_People_ConditionsVisibleKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'items'?
	 *
	 * This ambiguous syntax occurs at:
	 *     knowledges+=[Knowledge|ID] 'people'? 'paths'? (ambiguity) '}' (rule end)
	 *     name=ID '{' 'knowledge'? 'people'? 'paths'? (ambiguity) '}' (rule end)
	 *     paths+=[Path|ID] (ambiguity) '}' (rule end)
	 *     people+=[People|ID] 'paths'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Place_ItemsKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledge'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID '{' (ambiguity) 'people' people+=[People|ID]
	 *     name=ID '{' (ambiguity) 'people'? 'paths' paths+=[Path|ID]
	 *     name=ID '{' (ambiguity) 'people'? 'paths'? 'items' objects+=ItemInSomething
	 *     name=ID '{' (ambiguity) 'people'? 'paths'? 'items'? '}' (rule end)
	 */
	protected void emit_Place_KnowledgeKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'paths'?
	 *
	 * This ambiguous syntax occurs at:
	 *     knowledges+=[Knowledge|ID] 'people'? (ambiguity) 'items' objects+=ItemInSomething
	 *     knowledges+=[Knowledge|ID] 'people'? (ambiguity) 'items'? '}' (rule end)
	 *     name=ID '{' 'knowledge'? 'people'? (ambiguity) 'items' objects+=ItemInSomething
	 *     name=ID '{' 'knowledge'? 'people'? (ambiguity) 'items'? '}' (rule end)
	 *     people+=[People|ID] (ambiguity) 'items' objects+=ItemInSomething
	 *     people+=[People|ID] (ambiguity) 'items'? '}' (rule end)
	 */
	protected void emit_Place_PathsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'people'?
	 *
	 * This ambiguous syntax occurs at:
	 *     knowledges+=[Knowledge|ID] (ambiguity) 'paths' paths+=[Path|ID]
	 *     knowledges+=[Knowledge|ID] (ambiguity) 'paths'? 'items' objects+=ItemInSomething
	 *     knowledges+=[Knowledge|ID] (ambiguity) 'paths'? 'items'? '}' (rule end)
	 *     name=ID '{' 'knowledge'? (ambiguity) 'paths' paths+=[Path|ID]
	 *     name=ID '{' 'knowledge'? (ambiguity) 'paths'? 'items' objects+=ItemInSomething
	 *     name=ID '{' 'knowledge'? (ambiguity) 'paths'? 'items'? '}' (rule end)
	 */
	protected void emit_Place_PeopleKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'items'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=STRING '{' (ambiguity) 'knowledge' knowledge+=[Knowledge|ID]
	 *     name=STRING '{' (ambiguity) 'knowledge'? '}' (rule end)
	 */
	protected void emit_Player_ItemsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'knowledge'?
	 *
	 * This ambiguous syntax occurs at:
	 *     items+=ItemInSomething (ambiguity) '}' (rule end)
	 *     name=STRING '{' 'items'? (ambiguity) '}' (rule end)
	 */
	protected void emit_Player_KnowledgeKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'conditions'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID '{' 'itemsUsed' (ambiguity) 'itemsMade' '}' (rule end)
	 *     name=ID '{' 'itemsUsed' (ambiguity) 'itemsMade' itemsMade+=ItemInSomething
	 *     objectsUsed+=ItemInSomething (ambiguity) 'itemsMade' '}' (rule end)
	 *     objectsUsed+=ItemInSomething (ambiguity) 'itemsMade' itemsMade+=ItemInSomething
	 */
	protected void emit_Recipe_ConditionsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
