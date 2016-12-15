package fr.enseeiht.gls.projet404.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.enseeiht.gls.projet404.services.GamesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGamesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'game'", "':'", "'places'", "'['", "','", "']'", "'knowledge'", "'people'", "'items'", "'path'", "'recipes'", "'startPlace'", "'endPlace'", "'difficulty'", "'{'", "'sizeMax'", "'}'", "'player'", "'description'", "'visible'", "'conditionsVisible'", "'active'", "'conditionsActive'", "'isMandatory'", "'isOpen'", "'conditionsOpen'", "'knowledgesGiven'", "'itemsGiven'", "'itemsConsumed'", "'item'", "'size'", "'canPutDown'", "'conditionsPutDown'", "'conditionsGive'", "'conditionsConsumed'", "'('", "')'", "'recipe'", "'itemsUsed'", "'conditions'", "'itemsMade'", "'place'", "'paths'", "'condition'", "'action'", "'value'", "'nextInteraction'", "'knowledgeGiven'", "'conditionsActionsAvailable'", "'interaction'", "'propositions'", "'conditionsBegin'", "'conditionsEnd'", "'proposition'", "'TAKE_PATH'", "'TAKE_ITEM'", "'LEARN_KNOWLEDGE'", "'QUIT'", "'CONSUME_ITEM'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalGamesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGamesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGamesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGames.g"; }



     	private GamesGrammarAccess grammarAccess;

        public InternalGamesParser(TokenStream input, GamesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Game";
       	}

       	@Override
       	protected GamesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGame"
    // InternalGames.g:65:1: entryRuleGame returns [EObject current=null] : iv_ruleGame= ruleGame EOF ;
    public final EObject entryRuleGame() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGame = null;


        try {
            // InternalGames.g:65:45: (iv_ruleGame= ruleGame EOF )
            // InternalGames.g:66:2: iv_ruleGame= ruleGame EOF
            {
             newCompositeNode(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGame=ruleGame();

            state._fsp--;

             current =iv_ruleGame; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalGames.g:72:1: ruleGame returns [EObject current=null] : (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_player_3_0= rulePlayer ) ) otherlv_4= 'places' otherlv_5= '[' ( (lv_places_6_0= rulePlace ) ) (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )* otherlv_9= ']' (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )? otherlv_16= 'people' otherlv_17= '[' ( (lv_people_18_0= rulePeople ) ) (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )* otherlv_21= ']' (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )? otherlv_28= 'path' otherlv_29= '[' ( (lv_path_30_0= rulePath ) ) (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )* otherlv_33= ']' (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )? otherlv_40= 'startPlace' ( (otherlv_41= RULE_ID ) ) otherlv_42= 'endPlace' ( (otherlv_43= RULE_ID ) )+ ( (lv_difficulty_44_0= ruleDifficulty ) ) ) ;
    public final EObject ruleGame() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        EObject lv_player_3_0 = null;

        EObject lv_places_6_0 = null;

        EObject lv_places_8_0 = null;

        EObject lv_knowledge_12_0 = null;

        EObject lv_knowledge_14_0 = null;

        EObject lv_people_18_0 = null;

        EObject lv_people_20_0 = null;

        EObject lv_items_24_0 = null;

        EObject lv_items_26_0 = null;

        EObject lv_path_30_0 = null;

        EObject lv_path_32_0 = null;

        EObject lv_recipes_36_0 = null;

        EObject lv_recipes_38_0 = null;

        EObject lv_difficulty_44_0 = null;



        	enterRule();

        try {
            // InternalGames.g:78:2: ( (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_player_3_0= rulePlayer ) ) otherlv_4= 'places' otherlv_5= '[' ( (lv_places_6_0= rulePlace ) ) (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )* otherlv_9= ']' (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )? otherlv_16= 'people' otherlv_17= '[' ( (lv_people_18_0= rulePeople ) ) (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )* otherlv_21= ']' (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )? otherlv_28= 'path' otherlv_29= '[' ( (lv_path_30_0= rulePath ) ) (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )* otherlv_33= ']' (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )? otherlv_40= 'startPlace' ( (otherlv_41= RULE_ID ) ) otherlv_42= 'endPlace' ( (otherlv_43= RULE_ID ) )+ ( (lv_difficulty_44_0= ruleDifficulty ) ) ) )
            // InternalGames.g:79:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_player_3_0= rulePlayer ) ) otherlv_4= 'places' otherlv_5= '[' ( (lv_places_6_0= rulePlace ) ) (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )* otherlv_9= ']' (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )? otherlv_16= 'people' otherlv_17= '[' ( (lv_people_18_0= rulePeople ) ) (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )* otherlv_21= ']' (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )? otherlv_28= 'path' otherlv_29= '[' ( (lv_path_30_0= rulePath ) ) (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )* otherlv_33= ']' (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )? otherlv_40= 'startPlace' ( (otherlv_41= RULE_ID ) ) otherlv_42= 'endPlace' ( (otherlv_43= RULE_ID ) )+ ( (lv_difficulty_44_0= ruleDifficulty ) ) )
            {
            // InternalGames.g:79:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_player_3_0= rulePlayer ) ) otherlv_4= 'places' otherlv_5= '[' ( (lv_places_6_0= rulePlace ) ) (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )* otherlv_9= ']' (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )? otherlv_16= 'people' otherlv_17= '[' ( (lv_people_18_0= rulePeople ) ) (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )* otherlv_21= ']' (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )? otherlv_28= 'path' otherlv_29= '[' ( (lv_path_30_0= rulePath ) ) (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )* otherlv_33= ']' (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )? otherlv_40= 'startPlace' ( (otherlv_41= RULE_ID ) ) otherlv_42= 'endPlace' ( (otherlv_43= RULE_ID ) )+ ( (lv_difficulty_44_0= ruleDifficulty ) ) )
            // InternalGames.g:80:3: otherlv_0= 'game' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_player_3_0= rulePlayer ) ) otherlv_4= 'places' otherlv_5= '[' ( (lv_places_6_0= rulePlace ) ) (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )* otherlv_9= ']' (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )? otherlv_16= 'people' otherlv_17= '[' ( (lv_people_18_0= rulePeople ) ) (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )* otherlv_21= ']' (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )? otherlv_28= 'path' otherlv_29= '[' ( (lv_path_30_0= rulePath ) ) (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )* otherlv_33= ']' (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )? otherlv_40= 'startPlace' ( (otherlv_41= RULE_ID ) ) otherlv_42= 'endPlace' ( (otherlv_43= RULE_ID ) )+ ( (lv_difficulty_44_0= ruleDifficulty ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGameAccess().getGameKeyword_0());
            		
            // InternalGames.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGameAccess().getColonKeyword_2());
            		
            // InternalGames.g:106:3: ( (lv_player_3_0= rulePlayer ) )
            // InternalGames.g:107:4: (lv_player_3_0= rulePlayer )
            {
            // InternalGames.g:107:4: (lv_player_3_0= rulePlayer )
            // InternalGames.g:108:5: lv_player_3_0= rulePlayer
            {

            					newCompositeNode(grammarAccess.getGameAccess().getPlayerPlayerParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_player_3_0=rulePlayer();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"player",
            						lv_player_3_0,
            						"fr.enseeiht.gls.projet404.Games.Player");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getGameAccess().getPlacesKeyword_4());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalGames.g:133:3: ( (lv_places_6_0= rulePlace ) )
            // InternalGames.g:134:4: (lv_places_6_0= rulePlace )
            {
            // InternalGames.g:134:4: (lv_places_6_0= rulePlace )
            // InternalGames.g:135:5: lv_places_6_0= rulePlace
            {

            					newCompositeNode(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_9);
            lv_places_6_0=rulePlace();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					add(
            						current,
            						"places",
            						lv_places_6_0,
            						"fr.enseeiht.gls.projet404.Games.Place");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGames.g:152:3: (otherlv_7= ',' ( (lv_places_8_0= rulePlace ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGames.g:153:4: otherlv_7= ',' ( (lv_places_8_0= rulePlace ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_7, grammarAccess.getGameAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalGames.g:157:4: ( (lv_places_8_0= rulePlace ) )
            	    // InternalGames.g:158:5: (lv_places_8_0= rulePlace )
            	    {
            	    // InternalGames.g:158:5: (lv_places_8_0= rulePlace )
            	    // InternalGames.g:159:6: lv_places_8_0= rulePlace
            	    {

            	    						newCompositeNode(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_places_8_0=rulePlace();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGameRule());
            	    						}
            	    						add(
            	    							current,
            	    							"places",
            	    							lv_places_8_0,
            	    							"fr.enseeiht.gls.projet404.Games.Place");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_9=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getGameAccess().getRightSquareBracketKeyword_8());
            		
            // InternalGames.g:181:3: (otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalGames.g:182:4: otherlv_10= 'knowledge' otherlv_11= '[' ( (lv_knowledge_12_0= ruleKnowledge ) ) (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )* otherlv_15= ']'
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getGameAccess().getKnowledgeKeyword_9_0());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_9_1());
                    			
                    // InternalGames.g:190:4: ( (lv_knowledge_12_0= ruleKnowledge ) )
                    // InternalGames.g:191:5: (lv_knowledge_12_0= ruleKnowledge )
                    {
                    // InternalGames.g:191:5: (lv_knowledge_12_0= ruleKnowledge )
                    // InternalGames.g:192:6: lv_knowledge_12_0= ruleKnowledge
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_knowledge_12_0=ruleKnowledge();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"knowledge",
                    							lv_knowledge_12_0,
                    							"fr.enseeiht.gls.projet404.Games.Knowledge");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGames.g:209:4: (otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalGames.g:210:5: otherlv_13= ',' ( (lv_knowledge_14_0= ruleKnowledge ) )
                    	    {
                    	    otherlv_13=(Token)match(input,15,FOLLOW_11); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getGameAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalGames.g:214:5: ( (lv_knowledge_14_0= ruleKnowledge ) )
                    	    // InternalGames.g:215:6: (lv_knowledge_14_0= ruleKnowledge )
                    	    {
                    	    // InternalGames.g:215:6: (lv_knowledge_14_0= ruleKnowledge )
                    	    // InternalGames.g:216:7: lv_knowledge_14_0= ruleKnowledge
                    	    {

                    	    							newCompositeNode(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_knowledge_14_0=ruleKnowledge();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getGameRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"knowledge",
                    	    								lv_knowledge_14_0,
                    	    								"fr.enseeiht.gls.projet404.Games.Knowledge");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,16,FOLLOW_12); 

                    				newLeafNode(otherlv_15, grammarAccess.getGameAccess().getRightSquareBracketKeyword_9_4());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_16, grammarAccess.getGameAccess().getPeopleKeyword_10());
            		
            otherlv_17=(Token)match(input,14,FOLLOW_12); 

            			newLeafNode(otherlv_17, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_11());
            		
            // InternalGames.g:247:3: ( (lv_people_18_0= rulePeople ) )
            // InternalGames.g:248:4: (lv_people_18_0= rulePeople )
            {
            // InternalGames.g:248:4: (lv_people_18_0= rulePeople )
            // InternalGames.g:249:5: lv_people_18_0= rulePeople
            {

            					newCompositeNode(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_9);
            lv_people_18_0=rulePeople();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					add(
            						current,
            						"people",
            						lv_people_18_0,
            						"fr.enseeiht.gls.projet404.Games.People");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGames.g:266:3: (otherlv_19= ',' ( (lv_people_20_0= rulePeople ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGames.g:267:4: otherlv_19= ',' ( (lv_people_20_0= rulePeople ) )
            	    {
            	    otherlv_19=(Token)match(input,15,FOLLOW_12); 

            	    				newLeafNode(otherlv_19, grammarAccess.getGameAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalGames.g:271:4: ( (lv_people_20_0= rulePeople ) )
            	    // InternalGames.g:272:5: (lv_people_20_0= rulePeople )
            	    {
            	    // InternalGames.g:272:5: (lv_people_20_0= rulePeople )
            	    // InternalGames.g:273:6: lv_people_20_0= rulePeople
            	    {

            	    						newCompositeNode(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_people_20_0=rulePeople();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGameRule());
            	    						}
            	    						add(
            	    							current,
            	    							"people",
            	    							lv_people_20_0,
            	    							"fr.enseeiht.gls.projet404.Games.People");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_21=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_21, grammarAccess.getGameAccess().getRightSquareBracketKeyword_14());
            		
            // InternalGames.g:295:3: (otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalGames.g:296:4: otherlv_22= 'items' otherlv_23= '[' ( (lv_items_24_0= ruleItem ) ) (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )* otherlv_27= ']'
                    {
                    otherlv_22=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_22, grammarAccess.getGameAccess().getItemsKeyword_15_0());
                    			
                    otherlv_23=(Token)match(input,14,FOLLOW_14); 

                    				newLeafNode(otherlv_23, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_15_1());
                    			
                    // InternalGames.g:304:4: ( (lv_items_24_0= ruleItem ) )
                    // InternalGames.g:305:5: (lv_items_24_0= ruleItem )
                    {
                    // InternalGames.g:305:5: (lv_items_24_0= ruleItem )
                    // InternalGames.g:306:6: lv_items_24_0= ruleItem
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_items_24_0=ruleItem();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"items",
                    							lv_items_24_0,
                    							"fr.enseeiht.gls.projet404.Games.Item");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGames.g:323:4: (otherlv_25= ',' ( (lv_items_26_0= ruleItem ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalGames.g:324:5: otherlv_25= ',' ( (lv_items_26_0= ruleItem ) )
                    	    {
                    	    otherlv_25=(Token)match(input,15,FOLLOW_14); 

                    	    					newLeafNode(otherlv_25, grammarAccess.getGameAccess().getCommaKeyword_15_3_0());
                    	    				
                    	    // InternalGames.g:328:5: ( (lv_items_26_0= ruleItem ) )
                    	    // InternalGames.g:329:6: (lv_items_26_0= ruleItem )
                    	    {
                    	    // InternalGames.g:329:6: (lv_items_26_0= ruleItem )
                    	    // InternalGames.g:330:7: lv_items_26_0= ruleItem
                    	    {

                    	    							newCompositeNode(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_items_26_0=ruleItem();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getGameRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"items",
                    	    								lv_items_26_0,
                    	    								"fr.enseeiht.gls.projet404.Games.Item");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,16,FOLLOW_15); 

                    				newLeafNode(otherlv_27, grammarAccess.getGameAccess().getRightSquareBracketKeyword_15_4());
                    			

                    }
                    break;

            }

            otherlv_28=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_28, grammarAccess.getGameAccess().getPathKeyword_16());
            		
            otherlv_29=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_29, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_17());
            		
            // InternalGames.g:361:3: ( (lv_path_30_0= rulePath ) )
            // InternalGames.g:362:4: (lv_path_30_0= rulePath )
            {
            // InternalGames.g:362:4: (lv_path_30_0= rulePath )
            // InternalGames.g:363:5: lv_path_30_0= rulePath
            {

            					newCompositeNode(grammarAccess.getGameAccess().getPathPathParserRuleCall_18_0());
            				
            pushFollow(FOLLOW_9);
            lv_path_30_0=rulePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					add(
            						current,
            						"path",
            						lv_path_30_0,
            						"fr.enseeiht.gls.projet404.Games.Path");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGames.g:380:3: (otherlv_31= ',' ( (lv_path_32_0= rulePath ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalGames.g:381:4: otherlv_31= ',' ( (lv_path_32_0= rulePath ) )
            	    {
            	    otherlv_31=(Token)match(input,15,FOLLOW_15); 

            	    				newLeafNode(otherlv_31, grammarAccess.getGameAccess().getCommaKeyword_19_0());
            	    			
            	    // InternalGames.g:385:4: ( (lv_path_32_0= rulePath ) )
            	    // InternalGames.g:386:5: (lv_path_32_0= rulePath )
            	    {
            	    // InternalGames.g:386:5: (lv_path_32_0= rulePath )
            	    // InternalGames.g:387:6: lv_path_32_0= rulePath
            	    {

            	    						newCompositeNode(grammarAccess.getGameAccess().getPathPathParserRuleCall_19_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_path_32_0=rulePath();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGameRule());
            	    						}
            	    						add(
            	    							current,
            	    							"path",
            	    							lv_path_32_0,
            	    							"fr.enseeiht.gls.projet404.Games.Path");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_33=(Token)match(input,16,FOLLOW_16); 

            			newLeafNode(otherlv_33, grammarAccess.getGameAccess().getRightSquareBracketKeyword_20());
            		
            // InternalGames.g:409:3: (otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalGames.g:410:4: otherlv_34= 'recipes' otherlv_35= '[' ( (lv_recipes_36_0= ruleRecipe ) ) (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )* otherlv_39= ']'
                    {
                    otherlv_34=(Token)match(input,21,FOLLOW_7); 

                    				newLeafNode(otherlv_34, grammarAccess.getGameAccess().getRecipesKeyword_21_0());
                    			
                    otherlv_35=(Token)match(input,14,FOLLOW_17); 

                    				newLeafNode(otherlv_35, grammarAccess.getGameAccess().getLeftSquareBracketKeyword_21_1());
                    			
                    // InternalGames.g:418:4: ( (lv_recipes_36_0= ruleRecipe ) )
                    // InternalGames.g:419:5: (lv_recipes_36_0= ruleRecipe )
                    {
                    // InternalGames.g:419:5: (lv_recipes_36_0= ruleRecipe )
                    // InternalGames.g:420:6: lv_recipes_36_0= ruleRecipe
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_recipes_36_0=ruleRecipe();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						add(
                    							current,
                    							"recipes",
                    							lv_recipes_36_0,
                    							"fr.enseeiht.gls.projet404.Games.Recipe");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGames.g:437:4: (otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==15) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalGames.g:438:5: otherlv_37= ',' ( (lv_recipes_38_0= ruleRecipe ) )
                    	    {
                    	    otherlv_37=(Token)match(input,15,FOLLOW_17); 

                    	    					newLeafNode(otherlv_37, grammarAccess.getGameAccess().getCommaKeyword_21_3_0());
                    	    				
                    	    // InternalGames.g:442:5: ( (lv_recipes_38_0= ruleRecipe ) )
                    	    // InternalGames.g:443:6: (lv_recipes_38_0= ruleRecipe )
                    	    {
                    	    // InternalGames.g:443:6: (lv_recipes_38_0= ruleRecipe )
                    	    // InternalGames.g:444:7: lv_recipes_38_0= ruleRecipe
                    	    {

                    	    							newCompositeNode(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_recipes_38_0=ruleRecipe();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getGameRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"recipes",
                    	    								lv_recipes_38_0,
                    	    								"fr.enseeiht.gls.projet404.Games.Recipe");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,16,FOLLOW_18); 

                    				newLeafNode(otherlv_39, grammarAccess.getGameAccess().getRightSquareBracketKeyword_21_4());
                    			

                    }
                    break;

            }

            otherlv_40=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_40, grammarAccess.getGameAccess().getStartPlaceKeyword_22());
            		
            // InternalGames.g:471:3: ( (otherlv_41= RULE_ID ) )
            // InternalGames.g:472:4: (otherlv_41= RULE_ID )
            {
            // InternalGames.g:472:4: (otherlv_41= RULE_ID )
            // InternalGames.g:473:5: otherlv_41= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameRule());
            					}
            				
            otherlv_41=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_41, grammarAccess.getGameAccess().getStartPlacePlaceCrossReference_23_0());
            				

            }


            }

            otherlv_42=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_42, grammarAccess.getGameAccess().getEndPlaceKeyword_24());
            		
            // InternalGames.g:488:3: ( (otherlv_43= RULE_ID ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalGames.g:489:4: (otherlv_43= RULE_ID )
            	    {
            	    // InternalGames.g:489:4: (otherlv_43= RULE_ID )
            	    // InternalGames.g:490:5: otherlv_43= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getGameRule());
            	    					}
            	    				
            	    otherlv_43=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    					newLeafNode(otherlv_43, grammarAccess.getGameAccess().getEndPlacePlaceCrossReference_25_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // InternalGames.g:501:3: ( (lv_difficulty_44_0= ruleDifficulty ) )
            // InternalGames.g:502:4: (lv_difficulty_44_0= ruleDifficulty )
            {
            // InternalGames.g:502:4: (lv_difficulty_44_0= ruleDifficulty )
            // InternalGames.g:503:5: lv_difficulty_44_0= ruleDifficulty
            {

            					newCompositeNode(grammarAccess.getGameAccess().getDifficultyDifficultyParserRuleCall_26_0());
            				
            pushFollow(FOLLOW_2);
            lv_difficulty_44_0=ruleDifficulty();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"difficulty",
            						lv_difficulty_44_0,
            						"fr.enseeiht.gls.projet404.Games.Difficulty");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleDifficulty"
    // InternalGames.g:524:1: entryRuleDifficulty returns [EObject current=null] : iv_ruleDifficulty= ruleDifficulty EOF ;
    public final EObject entryRuleDifficulty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDifficulty = null;


        try {
            // InternalGames.g:524:51: (iv_ruleDifficulty= ruleDifficulty EOF )
            // InternalGames.g:525:2: iv_ruleDifficulty= ruleDifficulty EOF
            {
             newCompositeNode(grammarAccess.getDifficultyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDifficulty=ruleDifficulty();

            state._fsp--;

             current =iv_ruleDifficulty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDifficulty"


    // $ANTLR start "ruleDifficulty"
    // InternalGames.g:531:1: ruleDifficulty returns [EObject current=null] : (otherlv_0= 'difficulty' ( (lv_lvl_1_0= RULE_INT ) ) otherlv_2= '{' otherlv_3= 'sizeMax' ( (lv_sizeMax_4_0= RULE_INT ) ) (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )? (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleDifficulty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_lvl_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_sizeMax_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_items_7_0 = null;

        EObject lv_items_9_0 = null;



        	enterRule();

        try {
            // InternalGames.g:537:2: ( (otherlv_0= 'difficulty' ( (lv_lvl_1_0= RULE_INT ) ) otherlv_2= '{' otherlv_3= 'sizeMax' ( (lv_sizeMax_4_0= RULE_INT ) ) (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )? (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) )
            // InternalGames.g:538:2: (otherlv_0= 'difficulty' ( (lv_lvl_1_0= RULE_INT ) ) otherlv_2= '{' otherlv_3= 'sizeMax' ( (lv_sizeMax_4_0= RULE_INT ) ) (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )? (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            {
            // InternalGames.g:538:2: (otherlv_0= 'difficulty' ( (lv_lvl_1_0= RULE_INT ) ) otherlv_2= '{' otherlv_3= 'sizeMax' ( (lv_sizeMax_4_0= RULE_INT ) ) (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )? (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            // InternalGames.g:539:3: otherlv_0= 'difficulty' ( (lv_lvl_1_0= RULE_INT ) ) otherlv_2= '{' otherlv_3= 'sizeMax' ( (lv_sizeMax_4_0= RULE_INT ) ) (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )? (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getDifficultyAccess().getDifficultyKeyword_0());
            		
            // InternalGames.g:543:3: ( (lv_lvl_1_0= RULE_INT ) )
            // InternalGames.g:544:4: (lv_lvl_1_0= RULE_INT )
            {
            // InternalGames.g:544:4: (lv_lvl_1_0= RULE_INT )
            // InternalGames.g:545:5: lv_lvl_1_0= RULE_INT
            {
            lv_lvl_1_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_lvl_1_0, grammarAccess.getDifficultyAccess().getLvlINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDifficultyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"lvl",
            						lv_lvl_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getDifficultyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getDifficultyAccess().getSizeMaxKeyword_3());
            		
            // InternalGames.g:569:3: ( (lv_sizeMax_4_0= RULE_INT ) )
            // InternalGames.g:570:4: (lv_sizeMax_4_0= RULE_INT )
            {
            // InternalGames.g:570:4: (lv_sizeMax_4_0= RULE_INT )
            // InternalGames.g:571:5: lv_sizeMax_4_0= RULE_INT
            {
            lv_sizeMax_4_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            					newLeafNode(lv_sizeMax_4_0, grammarAccess.getDifficultyAccess().getSizeMaxINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDifficultyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"sizeMax",
            						lv_sizeMax_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:587:3: (otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalGames.g:588:4: otherlv_5= 'items' otherlv_6= '[' ( (lv_items_7_0= ruleItemInSomething ) ) (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )* otherlv_10= ']'
                    {
                    otherlv_5=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getDifficultyAccess().getItemsKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDifficultyAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalGames.g:596:4: ( (lv_items_7_0= ruleItemInSomething ) )
                    // InternalGames.g:597:5: (lv_items_7_0= ruleItemInSomething )
                    {
                    // InternalGames.g:597:5: (lv_items_7_0= ruleItemInSomething )
                    // InternalGames.g:598:6: lv_items_7_0= ruleItemInSomething
                    {

                    						newCompositeNode(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_items_7_0=ruleItemInSomething();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDifficultyRule());
                    						}
                    						add(
                    							current,
                    							"items",
                    							lv_items_7_0,
                    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGames.g:615:4: (otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalGames.g:616:5: otherlv_8= ',' ( (lv_items_9_0= ruleItemInSomething ) )
                    	    {
                    	    otherlv_8=(Token)match(input,15,FOLLOW_3); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getDifficultyAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalGames.g:620:5: ( (lv_items_9_0= ruleItemInSomething ) )
                    	    // InternalGames.g:621:6: (lv_items_9_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:621:6: (lv_items_9_0= ruleItemInSomething )
                    	    // InternalGames.g:622:7: lv_items_9_0= ruleItemInSomething
                    	    {

                    	    							newCompositeNode(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_items_9_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDifficultyRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"items",
                    	    								lv_items_9_0,
                    	    								"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_25); 

                    				newLeafNode(otherlv_10, grammarAccess.getDifficultyAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalGames.g:645:3: (otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalGames.g:646:4: otherlv_11= 'knowledge' ( (otherlv_12= RULE_ID ) )*
                    {
                    otherlv_11=(Token)match(input,17,FOLLOW_26); 

                    				newLeafNode(otherlv_11, grammarAccess.getDifficultyAccess().getKnowledgeKeyword_6_0());
                    			
                    // InternalGames.g:650:4: ( (otherlv_12= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalGames.g:651:5: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalGames.g:651:5: (otherlv_12= RULE_ID )
                    	    // InternalGames.g:652:6: otherlv_12= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getDifficultyRule());
                    	    						}
                    	    					
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_26); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getDifficultyAccess().getKnowledgesKnowledgeCrossReference_6_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getDifficultyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDifficulty"


    // $ANTLR start "entryRulePlayer"
    // InternalGames.g:672:1: entryRulePlayer returns [EObject current=null] : iv_rulePlayer= rulePlayer EOF ;
    public final EObject entryRulePlayer() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlayer = null;


        try {
            // InternalGames.g:672:47: (iv_rulePlayer= rulePlayer EOF )
            // InternalGames.g:673:2: iv_rulePlayer= rulePlayer EOF
            {
             newCompositeNode(grammarAccess.getPlayerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlayer=rulePlayer();

            state._fsp--;

             current =iv_rulePlayer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlayer"


    // $ANTLR start "rulePlayer"
    // InternalGames.g:679:1: rulePlayer returns [EObject current=null] : (otherlv_0= 'player' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )? (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' ) ;
    public final EObject rulePlayer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalGames.g:685:2: ( (otherlv_0= 'player' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )? (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' ) )
            // InternalGames.g:686:2: (otherlv_0= 'player' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )? (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' )
            {
            // InternalGames.g:686:2: (otherlv_0= 'player' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )? (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' )
            // InternalGames.g:687:3: otherlv_0= 'player' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )? (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getPlayerAccess().getPlayerKeyword_0());
            		
            // InternalGames.g:691:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalGames.g:692:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalGames.g:692:4: (lv_name_1_0= RULE_STRING )
            // InternalGames.g:693:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPlayerAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlayerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getPlayerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGames.g:713:3: (otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalGames.g:714:4: otherlv_3= 'items' ( (lv_items_4_0= ruleItemInSomething ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getPlayerAccess().getItemsKeyword_3_0());
                    			
                    // InternalGames.g:718:4: ( (lv_items_4_0= ruleItemInSomething ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalGames.g:719:5: (lv_items_4_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:719:5: (lv_items_4_0= ruleItemInSomething )
                    	    // InternalGames.g:720:6: lv_items_4_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getPlayerAccess().getItemsItemInSomethingParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    lv_items_4_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPlayerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"items",
                    	    							lv_items_4_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:738:3: (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalGames.g:739:4: otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )*
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_26); 

                    				newLeafNode(otherlv_5, grammarAccess.getPlayerAccess().getKnowledgeKeyword_4_0());
                    			
                    // InternalGames.g:743:4: ( (otherlv_6= RULE_ID ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalGames.g:744:5: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalGames.g:744:5: (otherlv_6= RULE_ID )
                    	    // InternalGames.g:745:6: otherlv_6= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPlayerRule());
                    	    						}
                    	    					
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_26); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getPlayerAccess().getKnowledgeKnowledgeCrossReference_4_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPlayerAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlayer"


    // $ANTLR start "entryRulePeople"
    // InternalGames.g:765:1: entryRulePeople returns [EObject current=null] : iv_rulePeople= rulePeople EOF ;
    public final EObject entryRulePeople() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePeople = null;


        try {
            // InternalGames.g:765:47: (iv_rulePeople= rulePeople EOF )
            // InternalGames.g:766:2: iv_rulePeople= rulePeople EOF
            {
             newCompositeNode(grammarAccess.getPeopleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePeople=rulePeople();

            state._fsp--;

             current =iv_rulePeople; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePeople"


    // $ANTLR start "rulePeople"
    // InternalGames.g:772:1: rulePeople returns [EObject current=null] : (otherlv_0= 'people' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? otherlv_13= 'isMandatory' ( (lv_isMandatory_14_0= RULE_INT ) ) ( (lv_interaction_15_0= ruleInteraction ) )? otherlv_16= '}' ) ;
    public final EObject rulePeople() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token lv_visible_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_active_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_isMandatory_14_0=null;
        Token otherlv_16=null;
        EObject lv_conditionsVisible_8_0 = null;

        EObject lv_conditionsActive_12_0 = null;

        EObject lv_interaction_15_0 = null;



        	enterRule();

        try {
            // InternalGames.g:778:2: ( (otherlv_0= 'people' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? otherlv_13= 'isMandatory' ( (lv_isMandatory_14_0= RULE_INT ) ) ( (lv_interaction_15_0= ruleInteraction ) )? otherlv_16= '}' ) )
            // InternalGames.g:779:2: (otherlv_0= 'people' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? otherlv_13= 'isMandatory' ( (lv_isMandatory_14_0= RULE_INT ) ) ( (lv_interaction_15_0= ruleInteraction ) )? otherlv_16= '}' )
            {
            // InternalGames.g:779:2: (otherlv_0= 'people' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? otherlv_13= 'isMandatory' ( (lv_isMandatory_14_0= RULE_INT ) ) ( (lv_interaction_15_0= ruleInteraction ) )? otherlv_16= '}' )
            // InternalGames.g:780:3: otherlv_0= 'people' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? otherlv_13= 'isMandatory' ( (lv_isMandatory_14_0= RULE_INT ) ) ( (lv_interaction_15_0= ruleInteraction ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPeopleAccess().getPeopleKeyword_0());
            		
            // InternalGames.g:784:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:785:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:785:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:786:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPeopleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeopleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getPeopleAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getPeopleAccess().getDescriptionKeyword_3());
            		
            // InternalGames.g:810:3: ( (lv_description_4_0= RULE_STRING ) )
            // InternalGames.g:811:4: (lv_description_4_0= RULE_STRING )
            {
            // InternalGames.g:811:4: (lv_description_4_0= RULE_STRING )
            // InternalGames.g:812:5: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_description_4_0, grammarAccess.getPeopleAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeopleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getPeopleAccess().getVisibleKeyword_5());
            		
            // InternalGames.g:832:3: ( (lv_visible_6_0= RULE_INT ) )
            // InternalGames.g:833:4: (lv_visible_6_0= RULE_INT )
            {
            // InternalGames.g:833:4: (lv_visible_6_0= RULE_INT )
            // InternalGames.g:834:5: lv_visible_6_0= RULE_INT
            {
            lv_visible_6_0=(Token)match(input,RULE_INT,FOLLOW_31); 

            					newLeafNode(lv_visible_6_0, grammarAccess.getPeopleAccess().getVisibleINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeopleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"visible",
            						lv_visible_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:850:3: (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalGames.g:851:4: otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )*
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_32); 

                    				newLeafNode(otherlv_7, grammarAccess.getPeopleAccess().getConditionsVisibleKeyword_7_0());
                    			
                    // InternalGames.g:855:4: ( (lv_conditionsVisible_8_0= ruleCondition ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==54) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalGames.g:856:5: (lv_conditionsVisible_8_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:856:5: (lv_conditionsVisible_8_0= ruleCondition )
                    	    // InternalGames.g:857:6: lv_conditionsVisible_8_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getPeopleAccess().getConditionsVisibleConditionParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_conditionsVisible_8_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPeopleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsVisible",
                    	    							lv_conditionsVisible_8_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_9, grammarAccess.getPeopleAccess().getActiveKeyword_8());
            		
            // InternalGames.g:879:3: ( (lv_active_10_0= RULE_INT ) )
            // InternalGames.g:880:4: (lv_active_10_0= RULE_INT )
            {
            // InternalGames.g:880:4: (lv_active_10_0= RULE_INT )
            // InternalGames.g:881:5: lv_active_10_0= RULE_INT
            {
            lv_active_10_0=(Token)match(input,RULE_INT,FOLLOW_33); 

            					newLeafNode(lv_active_10_0, grammarAccess.getPeopleAccess().getActiveINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeopleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"active",
            						lv_active_10_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:897:3: (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalGames.g:898:4: otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )*
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_34); 

                    				newLeafNode(otherlv_11, grammarAccess.getPeopleAccess().getConditionsActiveKeyword_10_0());
                    			
                    // InternalGames.g:902:4: ( (lv_conditionsActive_12_0= ruleCondition ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==54) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalGames.g:903:5: (lv_conditionsActive_12_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:903:5: (lv_conditionsActive_12_0= ruleCondition )
                    	    // InternalGames.g:904:6: lv_conditionsActive_12_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getPeopleAccess().getConditionsActiveConditionParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_conditionsActive_12_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPeopleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsActive",
                    	    							lv_conditionsActive_12_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,34,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getPeopleAccess().getIsMandatoryKeyword_11());
            		
            // InternalGames.g:926:3: ( (lv_isMandatory_14_0= RULE_INT ) )
            // InternalGames.g:927:4: (lv_isMandatory_14_0= RULE_INT )
            {
            // InternalGames.g:927:4: (lv_isMandatory_14_0= RULE_INT )
            // InternalGames.g:928:5: lv_isMandatory_14_0= RULE_INT
            {
            lv_isMandatory_14_0=(Token)match(input,RULE_INT,FOLLOW_35); 

            					newLeafNode(lv_isMandatory_14_0, grammarAccess.getPeopleAccess().getIsMandatoryINTTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeopleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"isMandatory",
            						lv_isMandatory_14_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:944:3: ( (lv_interaction_15_0= ruleInteraction ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==60) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalGames.g:945:4: (lv_interaction_15_0= ruleInteraction )
                    {
                    // InternalGames.g:945:4: (lv_interaction_15_0= ruleInteraction )
                    // InternalGames.g:946:5: lv_interaction_15_0= ruleInteraction
                    {

                    					newCompositeNode(grammarAccess.getPeopleAccess().getInteractionInteractionParserRuleCall_13_0());
                    				
                    pushFollow(FOLLOW_36);
                    lv_interaction_15_0=ruleInteraction();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPeopleRule());
                    					}
                    					set(
                    						current,
                    						"interaction",
                    						lv_interaction_15_0,
                    						"fr.enseeiht.gls.projet404.Games.Interaction");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getPeopleAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeople"


    // $ANTLR start "entryRulePath"
    // InternalGames.g:971:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalGames.g:971:45: (iv_rulePath= rulePath EOF )
            // InternalGames.g:972:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalGames.g:978:1: rulePath returns [EObject current=null] : (otherlv_0= 'path' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )? otherlv_9= 'endPlace' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'isOpen' ( (lv_isOpen_12_0= RULE_INT ) ) (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )? otherlv_15= 'isMandatory' ( (lv_isMandatory_16_0= RULE_INT ) ) (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )? (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )? (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )? otherlv_23= '}' ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token lv_visible_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_isOpen_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_isMandatory_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_conditionVisible_8_0 = null;

        EObject lv_conditionsOpening_14_0 = null;

        EObject lv_itemsGiven_20_0 = null;

        EObject lv_itemsConsumed_22_0 = null;



        	enterRule();

        try {
            // InternalGames.g:984:2: ( (otherlv_0= 'path' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )? otherlv_9= 'endPlace' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'isOpen' ( (lv_isOpen_12_0= RULE_INT ) ) (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )? otherlv_15= 'isMandatory' ( (lv_isMandatory_16_0= RULE_INT ) ) (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )? (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )? (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )? otherlv_23= '}' ) )
            // InternalGames.g:985:2: (otherlv_0= 'path' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )? otherlv_9= 'endPlace' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'isOpen' ( (lv_isOpen_12_0= RULE_INT ) ) (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )? otherlv_15= 'isMandatory' ( (lv_isMandatory_16_0= RULE_INT ) ) (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )? (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )? (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )? otherlv_23= '}' )
            {
            // InternalGames.g:985:2: (otherlv_0= 'path' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )? otherlv_9= 'endPlace' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'isOpen' ( (lv_isOpen_12_0= RULE_INT ) ) (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )? otherlv_15= 'isMandatory' ( (lv_isMandatory_16_0= RULE_INT ) ) (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )? (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )? (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )? otherlv_23= '}' )
            // InternalGames.g:986:3: otherlv_0= 'path' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )? otherlv_9= 'endPlace' ( (otherlv_10= RULE_ID ) ) otherlv_11= 'isOpen' ( (lv_isOpen_12_0= RULE_INT ) ) (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )? otherlv_15= 'isMandatory' ( (lv_isMandatory_16_0= RULE_INT ) ) (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )? (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )? (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )? otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPathAccess().getPathKeyword_0());
            		
            // InternalGames.g:990:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:991:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:991:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:992:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPathAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getPathAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getPathAccess().getDescriptionKeyword_3());
            		
            // InternalGames.g:1016:3: ( (lv_description_4_0= RULE_STRING ) )
            // InternalGames.g:1017:4: (lv_description_4_0= RULE_STRING )
            {
            // InternalGames.g:1017:4: (lv_description_4_0= RULE_STRING )
            // InternalGames.g:1018:5: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_description_4_0, grammarAccess.getPathAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getPathAccess().getVisibleKeyword_5());
            		
            // InternalGames.g:1038:3: ( (lv_visible_6_0= RULE_INT ) )
            // InternalGames.g:1039:4: (lv_visible_6_0= RULE_INT )
            {
            // InternalGames.g:1039:4: (lv_visible_6_0= RULE_INT )
            // InternalGames.g:1040:5: lv_visible_6_0= RULE_INT
            {
            lv_visible_6_0=(Token)match(input,RULE_INT,FOLLOW_37); 

            					newLeafNode(lv_visible_6_0, grammarAccess.getPathAccess().getVisibleINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"visible",
            						lv_visible_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1056:3: (otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalGames.g:1057:4: otherlv_7= 'conditionsVisible' ( (lv_conditionVisible_8_0= ruleCondition ) )*
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_38); 

                    				newLeafNode(otherlv_7, grammarAccess.getPathAccess().getConditionsVisibleKeyword_7_0());
                    			
                    // InternalGames.g:1061:4: ( (lv_conditionVisible_8_0= ruleCondition ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==54) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalGames.g:1062:5: (lv_conditionVisible_8_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1062:5: (lv_conditionVisible_8_0= ruleCondition )
                    	    // InternalGames.g:1063:6: lv_conditionVisible_8_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getPathAccess().getConditionVisibleConditionParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
                    	    lv_conditionVisible_8_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPathRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionVisible",
                    	    							lv_conditionVisible_8_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getPathAccess().getEndPlaceKeyword_8());
            		
            // InternalGames.g:1085:3: ( (otherlv_10= RULE_ID ) )
            // InternalGames.g:1086:4: (otherlv_10= RULE_ID )
            {
            // InternalGames.g:1086:4: (otherlv_10= RULE_ID )
            // InternalGames.g:1087:5: otherlv_10= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            				
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_10, grammarAccess.getPathAccess().getEndPlacePlaceCrossReference_9_0());
            				

            }


            }

            otherlv_11=(Token)match(input,35,FOLLOW_21); 

            			newLeafNode(otherlv_11, grammarAccess.getPathAccess().getIsOpenKeyword_10());
            		
            // InternalGames.g:1102:3: ( (lv_isOpen_12_0= RULE_INT ) )
            // InternalGames.g:1103:4: (lv_isOpen_12_0= RULE_INT )
            {
            // InternalGames.g:1103:4: (lv_isOpen_12_0= RULE_INT )
            // InternalGames.g:1104:5: lv_isOpen_12_0= RULE_INT
            {
            lv_isOpen_12_0=(Token)match(input,RULE_INT,FOLLOW_40); 

            					newLeafNode(lv_isOpen_12_0, grammarAccess.getPathAccess().getIsOpenINTTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"isOpen",
            						lv_isOpen_12_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1120:3: (otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalGames.g:1121:4: otherlv_13= 'conditionsOpen' ( (lv_conditionsOpening_14_0= ruleCondition ) )*
                    {
                    otherlv_13=(Token)match(input,36,FOLLOW_34); 

                    				newLeafNode(otherlv_13, grammarAccess.getPathAccess().getConditionsOpenKeyword_12_0());
                    			
                    // InternalGames.g:1125:4: ( (lv_conditionsOpening_14_0= ruleCondition ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==54) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalGames.g:1126:5: (lv_conditionsOpening_14_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1126:5: (lv_conditionsOpening_14_0= ruleCondition )
                    	    // InternalGames.g:1127:6: lv_conditionsOpening_14_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getPathAccess().getConditionsOpeningConditionParserRuleCall_12_1_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_conditionsOpening_14_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPathRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsOpening",
                    	    							lv_conditionsOpening_14_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,34,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getPathAccess().getIsMandatoryKeyword_13());
            		
            // InternalGames.g:1149:3: ( (lv_isMandatory_16_0= RULE_INT ) )
            // InternalGames.g:1150:4: (lv_isMandatory_16_0= RULE_INT )
            {
            // InternalGames.g:1150:4: (lv_isMandatory_16_0= RULE_INT )
            // InternalGames.g:1151:5: lv_isMandatory_16_0= RULE_INT
            {
            lv_isMandatory_16_0=(Token)match(input,RULE_INT,FOLLOW_41); 

            					newLeafNode(lv_isMandatory_16_0, grammarAccess.getPathAccess().getIsMandatoryINTTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"isMandatory",
            						lv_isMandatory_16_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1167:3: (otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGames.g:1168:4: otherlv_17= 'knowledgesGiven' ( (otherlv_18= RULE_ID ) )*
                    {
                    otherlv_17=(Token)match(input,37,FOLLOW_42); 

                    				newLeafNode(otherlv_17, grammarAccess.getPathAccess().getKnowledgesGivenKeyword_15_0());
                    			
                    // InternalGames.g:1172:4: ( (otherlv_18= RULE_ID ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalGames.g:1173:5: (otherlv_18= RULE_ID )
                    	    {
                    	    // InternalGames.g:1173:5: (otherlv_18= RULE_ID )
                    	    // InternalGames.g:1174:6: otherlv_18= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPathRule());
                    	    						}
                    	    					
                    	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_42); 

                    	    						newLeafNode(otherlv_18, grammarAccess.getPathAccess().getKnowledgeGivenKnowledgeCrossReference_15_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1186:3: (otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==38) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalGames.g:1187:4: otherlv_19= 'itemsGiven' ( (lv_itemsGiven_20_0= ruleItemInSomething ) )*
                    {
                    otherlv_19=(Token)match(input,38,FOLLOW_43); 

                    				newLeafNode(otherlv_19, grammarAccess.getPathAccess().getItemsGivenKeyword_16_0());
                    			
                    // InternalGames.g:1191:4: ( (lv_itemsGiven_20_0= ruleItemInSomething ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalGames.g:1192:5: (lv_itemsGiven_20_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:1192:5: (lv_itemsGiven_20_0= ruleItemInSomething )
                    	    // InternalGames.g:1193:6: lv_itemsGiven_20_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getPathAccess().getItemsGivenItemInSomethingParserRuleCall_16_1_0());
                    	    					
                    	    pushFollow(FOLLOW_43);
                    	    lv_itemsGiven_20_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPathRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"itemsGiven",
                    	    							lv_itemsGiven_20_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1211:3: (otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==39) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalGames.g:1212:4: otherlv_21= 'itemsConsumed' ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )*
                    {
                    otherlv_21=(Token)match(input,39,FOLLOW_26); 

                    				newLeafNode(otherlv_21, grammarAccess.getPathAccess().getItemsConsumedKeyword_17_0());
                    			
                    // InternalGames.g:1216:4: ( (lv_itemsConsumed_22_0= ruleItemInSomething ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalGames.g:1217:5: (lv_itemsConsumed_22_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:1217:5: (lv_itemsConsumed_22_0= ruleItemInSomething )
                    	    // InternalGames.g:1218:6: lv_itemsConsumed_22_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getPathAccess().getItemsConsumedItemInSomethingParserRuleCall_17_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_itemsConsumed_22_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPathRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"itemsConsumed",
                    	    							lv_itemsConsumed_22_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_23=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_23, grammarAccess.getPathAccess().getRightCurlyBracketKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleItem"
    // InternalGames.g:1244:1: entryRuleItem returns [EObject current=null] : iv_ruleItem= ruleItem EOF ;
    public final EObject entryRuleItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleItem = null;


        try {
            // InternalGames.g:1244:45: (iv_ruleItem= ruleItem EOF )
            // InternalGames.g:1245:2: iv_ruleItem= ruleItem EOF
            {
             newCompositeNode(grammarAccess.getItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleItem=ruleItem();

            state._fsp--;

             current =iv_ruleItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleItem"


    // $ANTLR start "ruleItem"
    // InternalGames.g:1251:1: ruleItem returns [EObject current=null] : (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'size' ( (lv_size_4_0= RULE_INT ) ) otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) otherlv_7= 'visible' ( (lv_visible_8_0= RULE_INT ) ) (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )? otherlv_11= 'active' ( (lv_active_12_0= RULE_INT ) ) otherlv_13= 'conditionsActive' ( (lv_conditionsActive_14_0= ruleCondition ) )* otherlv_15= 'canPutDown' ( (lv_canPutDown_16_0= RULE_INT ) ) (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )? (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )? (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )? otherlv_23= '}' ) ;
    public final EObject ruleItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_size_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        Token lv_visible_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_active_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_canPutDown_16_0=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_conditionsVisible_10_0 = null;

        EObject lv_conditionsActive_14_0 = null;

        EObject lv_conditionsPutDown_18_0 = null;

        EObject lv_conditionsGive_20_0 = null;

        EObject lv_conditionsConsumed_22_0 = null;



        	enterRule();

        try {
            // InternalGames.g:1257:2: ( (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'size' ( (lv_size_4_0= RULE_INT ) ) otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) otherlv_7= 'visible' ( (lv_visible_8_0= RULE_INT ) ) (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )? otherlv_11= 'active' ( (lv_active_12_0= RULE_INT ) ) otherlv_13= 'conditionsActive' ( (lv_conditionsActive_14_0= ruleCondition ) )* otherlv_15= 'canPutDown' ( (lv_canPutDown_16_0= RULE_INT ) ) (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )? (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )? (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )? otherlv_23= '}' ) )
            // InternalGames.g:1258:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'size' ( (lv_size_4_0= RULE_INT ) ) otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) otherlv_7= 'visible' ( (lv_visible_8_0= RULE_INT ) ) (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )? otherlv_11= 'active' ( (lv_active_12_0= RULE_INT ) ) otherlv_13= 'conditionsActive' ( (lv_conditionsActive_14_0= ruleCondition ) )* otherlv_15= 'canPutDown' ( (lv_canPutDown_16_0= RULE_INT ) ) (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )? (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )? (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )? otherlv_23= '}' )
            {
            // InternalGames.g:1258:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'size' ( (lv_size_4_0= RULE_INT ) ) otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) otherlv_7= 'visible' ( (lv_visible_8_0= RULE_INT ) ) (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )? otherlv_11= 'active' ( (lv_active_12_0= RULE_INT ) ) otherlv_13= 'conditionsActive' ( (lv_conditionsActive_14_0= ruleCondition ) )* otherlv_15= 'canPutDown' ( (lv_canPutDown_16_0= RULE_INT ) ) (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )? (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )? (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )? otherlv_23= '}' )
            // InternalGames.g:1259:3: otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'size' ( (lv_size_4_0= RULE_INT ) ) otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) otherlv_7= 'visible' ( (lv_visible_8_0= RULE_INT ) ) (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )? otherlv_11= 'active' ( (lv_active_12_0= RULE_INT ) ) otherlv_13= 'conditionsActive' ( (lv_conditionsActive_14_0= ruleCondition ) )* otherlv_15= 'canPutDown' ( (lv_canPutDown_16_0= RULE_INT ) ) (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )? (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )? (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )? otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getItemAccess().getItemKeyword_0());
            		
            // InternalGames.g:1263:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:1264:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:1264:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:1265:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getItemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getItemAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getItemAccess().getSizeKeyword_3());
            		
            // InternalGames.g:1289:3: ( (lv_size_4_0= RULE_INT ) )
            // InternalGames.g:1290:4: (lv_size_4_0= RULE_INT )
            {
            // InternalGames.g:1290:4: (lv_size_4_0= RULE_INT )
            // InternalGames.g:1291:5: lv_size_4_0= RULE_INT
            {
            lv_size_4_0=(Token)match(input,RULE_INT,FOLLOW_29); 

            					newLeafNode(lv_size_4_0, grammarAccess.getItemAccess().getSizeINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"size",
            						lv_size_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_5, grammarAccess.getItemAccess().getDescriptionKeyword_5());
            		
            // InternalGames.g:1311:3: ( (lv_description_6_0= RULE_STRING ) )
            // InternalGames.g:1312:4: (lv_description_6_0= RULE_STRING )
            {
            // InternalGames.g:1312:4: (lv_description_6_0= RULE_STRING )
            // InternalGames.g:1313:5: lv_description_6_0= RULE_STRING
            {
            lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_description_6_0, grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getItemAccess().getVisibleKeyword_7());
            		
            // InternalGames.g:1333:3: ( (lv_visible_8_0= RULE_INT ) )
            // InternalGames.g:1334:4: (lv_visible_8_0= RULE_INT )
            {
            // InternalGames.g:1334:4: (lv_visible_8_0= RULE_INT )
            // InternalGames.g:1335:5: lv_visible_8_0= RULE_INT
            {
            lv_visible_8_0=(Token)match(input,RULE_INT,FOLLOW_31); 

            					newLeafNode(lv_visible_8_0, grammarAccess.getItemAccess().getVisibleINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"visible",
            						lv_visible_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1351:3: (otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGames.g:1352:4: otherlv_9= 'conditionsVisible' ( (lv_conditionsVisible_10_0= ruleCondition ) )*
                    {
                    otherlv_9=(Token)match(input,31,FOLLOW_32); 

                    				newLeafNode(otherlv_9, grammarAccess.getItemAccess().getConditionsVisibleKeyword_9_0());
                    			
                    // InternalGames.g:1356:4: ( (lv_conditionsVisible_10_0= ruleCondition ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==54) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalGames.g:1357:5: (lv_conditionsVisible_10_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1357:5: (lv_conditionsVisible_10_0= ruleCondition )
                    	    // InternalGames.g:1358:6: lv_conditionsVisible_10_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getItemAccess().getConditionsVisibleConditionParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_conditionsVisible_10_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getItemRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsVisible",
                    	    							lv_conditionsVisible_10_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_11, grammarAccess.getItemAccess().getActiveKeyword_10());
            		
            // InternalGames.g:1380:3: ( (lv_active_12_0= RULE_INT ) )
            // InternalGames.g:1381:4: (lv_active_12_0= RULE_INT )
            {
            // InternalGames.g:1381:4: (lv_active_12_0= RULE_INT )
            // InternalGames.g:1382:5: lv_active_12_0= RULE_INT
            {
            lv_active_12_0=(Token)match(input,RULE_INT,FOLLOW_45); 

            					newLeafNode(lv_active_12_0, grammarAccess.getItemAccess().getActiveINTTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"active",
            						lv_active_12_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_13=(Token)match(input,33,FOLLOW_46); 

            			newLeafNode(otherlv_13, grammarAccess.getItemAccess().getConditionsActiveKeyword_12());
            		
            // InternalGames.g:1402:3: ( (lv_conditionsActive_14_0= ruleCondition ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalGames.g:1403:4: (lv_conditionsActive_14_0= ruleCondition )
            	    {
            	    // InternalGames.g:1403:4: (lv_conditionsActive_14_0= ruleCondition )
            	    // InternalGames.g:1404:5: lv_conditionsActive_14_0= ruleCondition
            	    {

            	    					newCompositeNode(grammarAccess.getItemAccess().getConditionsActiveConditionParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_conditionsActive_14_0=ruleCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getItemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conditionsActive",
            	    						lv_conditionsActive_14_0,
            	    						"fr.enseeiht.gls.projet404.Games.Condition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_15=(Token)match(input,42,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getItemAccess().getCanPutDownKeyword_14());
            		
            // InternalGames.g:1425:3: ( (lv_canPutDown_16_0= RULE_INT ) )
            // InternalGames.g:1426:4: (lv_canPutDown_16_0= RULE_INT )
            {
            // InternalGames.g:1426:4: (lv_canPutDown_16_0= RULE_INT )
            // InternalGames.g:1427:5: lv_canPutDown_16_0= RULE_INT
            {
            lv_canPutDown_16_0=(Token)match(input,RULE_INT,FOLLOW_47); 

            					newLeafNode(lv_canPutDown_16_0, grammarAccess.getItemAccess().getCanPutDownINTTerminalRuleCall_15_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"canPutDown",
            						lv_canPutDown_16_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1443:3: (otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==43) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalGames.g:1444:4: otherlv_17= 'conditionsPutDown' ( (lv_conditionsPutDown_18_0= ruleCondition ) )*
                    {
                    otherlv_17=(Token)match(input,43,FOLLOW_48); 

                    				newLeafNode(otherlv_17, grammarAccess.getItemAccess().getConditionsPutDownKeyword_16_0());
                    			
                    // InternalGames.g:1448:4: ( (lv_conditionsPutDown_18_0= ruleCondition ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==54) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalGames.g:1449:5: (lv_conditionsPutDown_18_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1449:5: (lv_conditionsPutDown_18_0= ruleCondition )
                    	    // InternalGames.g:1450:6: lv_conditionsPutDown_18_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getItemAccess().getConditionsPutDownConditionParserRuleCall_16_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
                    	    lv_conditionsPutDown_18_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getItemRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsPutDown",
                    	    							lv_conditionsPutDown_18_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1468:3: (otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==44) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalGames.g:1469:4: otherlv_19= 'conditionsGive' ( (lv_conditionsGive_20_0= ruleCondition ) )*
                    {
                    otherlv_19=(Token)match(input,44,FOLLOW_49); 

                    				newLeafNode(otherlv_19, grammarAccess.getItemAccess().getConditionsGiveKeyword_17_0());
                    			
                    // InternalGames.g:1473:4: ( (lv_conditionsGive_20_0= ruleCondition ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==54) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalGames.g:1474:5: (lv_conditionsGive_20_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1474:5: (lv_conditionsGive_20_0= ruleCondition )
                    	    // InternalGames.g:1475:6: lv_conditionsGive_20_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getItemAccess().getConditionsGiveConditionParserRuleCall_17_1_0());
                    	    					
                    	    pushFollow(FOLLOW_49);
                    	    lv_conditionsGive_20_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getItemRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsGive",
                    	    							lv_conditionsGive_20_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1493:3: (otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==45) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalGames.g:1494:4: otherlv_21= 'conditionsConsumed' ( (lv_conditionsConsumed_22_0= ruleCondition ) )*
                    {
                    otherlv_21=(Token)match(input,45,FOLLOW_50); 

                    				newLeafNode(otherlv_21, grammarAccess.getItemAccess().getConditionsConsumedKeyword_18_0());
                    			
                    // InternalGames.g:1498:4: ( (lv_conditionsConsumed_22_0= ruleCondition ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==54) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalGames.g:1499:5: (lv_conditionsConsumed_22_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1499:5: (lv_conditionsConsumed_22_0= ruleCondition )
                    	    // InternalGames.g:1500:6: lv_conditionsConsumed_22_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getItemAccess().getConditionsConsumedConditionParserRuleCall_18_1_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_conditionsConsumed_22_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getItemRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsConsumed",
                    	    							lv_conditionsConsumed_22_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_23=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_23, grammarAccess.getItemAccess().getRightCurlyBracketKeyword_19());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleItem"


    // $ANTLR start "entryRuleItemInSomething"
    // InternalGames.g:1526:1: entryRuleItemInSomething returns [EObject current=null] : iv_ruleItemInSomething= ruleItemInSomething EOF ;
    public final EObject entryRuleItemInSomething() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleItemInSomething = null;


        try {
            // InternalGames.g:1526:56: (iv_ruleItemInSomething= ruleItemInSomething EOF )
            // InternalGames.g:1527:2: iv_ruleItemInSomething= ruleItemInSomething EOF
            {
             newCompositeNode(grammarAccess.getItemInSomethingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleItemInSomething=ruleItemInSomething();

            state._fsp--;

             current =iv_ruleItemInSomething; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleItemInSomething"


    // $ANTLR start "ruleItemInSomething"
    // InternalGames.g:1533:1: ruleItemInSomething returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_quantite_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject ruleItemInSomething() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_quantite_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGames.g:1539:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_quantite_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalGames.g:1540:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_quantite_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalGames.g:1540:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_quantite_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalGames.g:1541:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_quantite_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            // InternalGames.g:1541:3: ( (otherlv_0= RULE_ID ) )
            // InternalGames.g:1542:4: (otherlv_0= RULE_ID )
            {
            // InternalGames.g:1542:4: (otherlv_0= RULE_ID )
            // InternalGames.g:1543:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemInSomethingRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_51); 

            					newLeafNode(otherlv_0, grammarAccess.getItemInSomethingAccess().getItemItemCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,46,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getItemInSomethingAccess().getLeftParenthesisKeyword_1());
            		
            // InternalGames.g:1558:3: ( (lv_quantite_2_0= RULE_INT ) )
            // InternalGames.g:1559:4: (lv_quantite_2_0= RULE_INT )
            {
            // InternalGames.g:1559:4: (lv_quantite_2_0= RULE_INT )
            // InternalGames.g:1560:5: lv_quantite_2_0= RULE_INT
            {
            lv_quantite_2_0=(Token)match(input,RULE_INT,FOLLOW_52); 

            					newLeafNode(lv_quantite_2_0, grammarAccess.getItemInSomethingAccess().getQuantiteINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemInSomethingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantite",
            						lv_quantite_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,47,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getItemInSomethingAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleItemInSomething"


    // $ANTLR start "entryRuleRecipe"
    // InternalGames.g:1584:1: entryRuleRecipe returns [EObject current=null] : iv_ruleRecipe= ruleRecipe EOF ;
    public final EObject entryRuleRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecipe = null;


        try {
            // InternalGames.g:1584:47: (iv_ruleRecipe= ruleRecipe EOF )
            // InternalGames.g:1585:2: iv_ruleRecipe= ruleRecipe EOF
            {
             newCompositeNode(grammarAccess.getRecipeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecipe=ruleRecipe();

            state._fsp--;

             current =iv_ruleRecipe; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecipe"


    // $ANTLR start "ruleRecipe"
    // InternalGames.g:1591:1: ruleRecipe returns [EObject current=null] : (otherlv_0= 'recipe' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'itemsUsed' ( (lv_objectsUsed_4_0= ruleItemInSomething ) )* (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )? otherlv_7= 'itemsMade' ( (lv_itemsMade_8_0= ruleItemInSomething ) )* otherlv_9= '}' ) ;
    public final EObject ruleRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_objectsUsed_4_0 = null;

        EObject lv_conditions_6_0 = null;

        EObject lv_itemsMade_8_0 = null;



        	enterRule();

        try {
            // InternalGames.g:1597:2: ( (otherlv_0= 'recipe' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'itemsUsed' ( (lv_objectsUsed_4_0= ruleItemInSomething ) )* (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )? otherlv_7= 'itemsMade' ( (lv_itemsMade_8_0= ruleItemInSomething ) )* otherlv_9= '}' ) )
            // InternalGames.g:1598:2: (otherlv_0= 'recipe' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'itemsUsed' ( (lv_objectsUsed_4_0= ruleItemInSomething ) )* (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )? otherlv_7= 'itemsMade' ( (lv_itemsMade_8_0= ruleItemInSomething ) )* otherlv_9= '}' )
            {
            // InternalGames.g:1598:2: (otherlv_0= 'recipe' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'itemsUsed' ( (lv_objectsUsed_4_0= ruleItemInSomething ) )* (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )? otherlv_7= 'itemsMade' ( (lv_itemsMade_8_0= ruleItemInSomething ) )* otherlv_9= '}' )
            // InternalGames.g:1599:3: otherlv_0= 'recipe' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'itemsUsed' ( (lv_objectsUsed_4_0= ruleItemInSomething ) )* (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )? otherlv_7= 'itemsMade' ( (lv_itemsMade_8_0= ruleItemInSomething ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRecipeAccess().getRecipeKeyword_0());
            		
            // InternalGames.g:1603:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:1604:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:1604:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:1605:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRecipeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRecipeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_53); 

            			newLeafNode(otherlv_2, grammarAccess.getRecipeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_54); 

            			newLeafNode(otherlv_3, grammarAccess.getRecipeAccess().getItemsUsedKeyword_3());
            		
            // InternalGames.g:1629:3: ( (lv_objectsUsed_4_0= ruleItemInSomething ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalGames.g:1630:4: (lv_objectsUsed_4_0= ruleItemInSomething )
            	    {
            	    // InternalGames.g:1630:4: (lv_objectsUsed_4_0= ruleItemInSomething )
            	    // InternalGames.g:1631:5: lv_objectsUsed_4_0= ruleItemInSomething
            	    {

            	    					newCompositeNode(grammarAccess.getRecipeAccess().getObjectsUsedItemInSomethingParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_objectsUsed_4_0=ruleItemInSomething();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRecipeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"objectsUsed",
            	    						lv_objectsUsed_4_0,
            	    						"fr.enseeiht.gls.projet404.Games.ItemInSomething");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // InternalGames.g:1648:3: (otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==50) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalGames.g:1649:4: otherlv_5= 'conditions' ( (lv_conditions_6_0= ruleCondition ) )*
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_55); 

                    				newLeafNode(otherlv_5, grammarAccess.getRecipeAccess().getConditionsKeyword_5_0());
                    			
                    // InternalGames.g:1653:4: ( (lv_conditions_6_0= ruleCondition ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==54) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalGames.g:1654:5: (lv_conditions_6_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1654:5: (lv_conditions_6_0= ruleCondition )
                    	    // InternalGames.g:1655:6: lv_conditions_6_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getRecipeAccess().getConditionsConditionParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_conditions_6_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRecipeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditions",
                    	    							lv_conditions_6_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,51,FOLLOW_26); 

            			newLeafNode(otherlv_7, grammarAccess.getRecipeAccess().getItemsMadeKeyword_6());
            		
            // InternalGames.g:1677:3: ( (lv_itemsMade_8_0= ruleItemInSomething ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalGames.g:1678:4: (lv_itemsMade_8_0= ruleItemInSomething )
            	    {
            	    // InternalGames.g:1678:4: (lv_itemsMade_8_0= ruleItemInSomething )
            	    // InternalGames.g:1679:5: lv_itemsMade_8_0= ruleItemInSomething
            	    {

            	    					newCompositeNode(grammarAccess.getRecipeAccess().getItemsMadeItemInSomethingParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_26);
            	    lv_itemsMade_8_0=ruleItemInSomething();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRecipeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"itemsMade",
            	    						lv_itemsMade_8_0,
            	    						"fr.enseeiht.gls.projet404.Games.ItemInSomething");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_9=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRecipeAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecipe"


    // $ANTLR start "entryRuleKnowledge"
    // InternalGames.g:1704:1: entryRuleKnowledge returns [EObject current=null] : iv_ruleKnowledge= ruleKnowledge EOF ;
    public final EObject entryRuleKnowledge() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKnowledge = null;


        try {
            // InternalGames.g:1704:50: (iv_ruleKnowledge= ruleKnowledge EOF )
            // InternalGames.g:1705:2: iv_ruleKnowledge= ruleKnowledge EOF
            {
             newCompositeNode(grammarAccess.getKnowledgeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKnowledge=ruleKnowledge();

            state._fsp--;

             current =iv_ruleKnowledge; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKnowledge"


    // $ANTLR start "ruleKnowledge"
    // InternalGames.g:1711:1: ruleKnowledge returns [EObject current=null] : (otherlv_0= 'knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )? otherlv_15= '}' ) ;
    public final EObject ruleKnowledge() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token lv_visible_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_active_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_conditionsVisible_8_0 = null;

        EObject lv_conditionsActive_12_0 = null;

        EObject lv_conditionsGive_14_0 = null;



        	enterRule();

        try {
            // InternalGames.g:1717:2: ( (otherlv_0= 'knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )? otherlv_15= '}' ) )
            // InternalGames.g:1718:2: (otherlv_0= 'knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )? otherlv_15= '}' )
            {
            // InternalGames.g:1718:2: (otherlv_0= 'knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )? otherlv_15= '}' )
            // InternalGames.g:1719:3: otherlv_0= 'knowledge' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= 'visible' ( (lv_visible_6_0= RULE_INT ) ) (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )? otherlv_9= 'active' ( (lv_active_10_0= RULE_INT ) ) (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )? (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getKnowledgeAccess().getKnowledgeKeyword_0());
            		
            // InternalGames.g:1723:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:1724:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:1724:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:1725:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getKnowledgeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKnowledgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getKnowledgeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getKnowledgeAccess().getDescriptionKeyword_3());
            		
            // InternalGames.g:1749:3: ( (lv_description_4_0= RULE_STRING ) )
            // InternalGames.g:1750:4: (lv_description_4_0= RULE_STRING )
            {
            // InternalGames.g:1750:4: (lv_description_4_0= RULE_STRING )
            // InternalGames.g:1751:5: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            					newLeafNode(lv_description_4_0, grammarAccess.getKnowledgeAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKnowledgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getKnowledgeAccess().getVisibleKeyword_5());
            		
            // InternalGames.g:1771:3: ( (lv_visible_6_0= RULE_INT ) )
            // InternalGames.g:1772:4: (lv_visible_6_0= RULE_INT )
            {
            // InternalGames.g:1772:4: (lv_visible_6_0= RULE_INT )
            // InternalGames.g:1773:5: lv_visible_6_0= RULE_INT
            {
            lv_visible_6_0=(Token)match(input,RULE_INT,FOLLOW_31); 

            					newLeafNode(lv_visible_6_0, grammarAccess.getKnowledgeAccess().getVisibleINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKnowledgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"visible",
            						lv_visible_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1789:3: (otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==31) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalGames.g:1790:4: otherlv_7= 'conditionsVisible' ( (lv_conditionsVisible_8_0= ruleCondition ) )*
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_32); 

                    				newLeafNode(otherlv_7, grammarAccess.getKnowledgeAccess().getConditionsVisibleKeyword_7_0());
                    			
                    // InternalGames.g:1794:4: ( (lv_conditionsVisible_8_0= ruleCondition ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==54) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalGames.g:1795:5: (lv_conditionsVisible_8_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1795:5: (lv_conditionsVisible_8_0= ruleCondition )
                    	    // InternalGames.g:1796:6: lv_conditionsVisible_8_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getKnowledgeAccess().getConditionsVisibleConditionParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_conditionsVisible_8_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getKnowledgeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsVisible",
                    	    							lv_conditionsVisible_8_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_9, grammarAccess.getKnowledgeAccess().getActiveKeyword_8());
            		
            // InternalGames.g:1818:3: ( (lv_active_10_0= RULE_INT ) )
            // InternalGames.g:1819:4: (lv_active_10_0= RULE_INT )
            {
            // InternalGames.g:1819:4: (lv_active_10_0= RULE_INT )
            // InternalGames.g:1820:5: lv_active_10_0= RULE_INT
            {
            lv_active_10_0=(Token)match(input,RULE_INT,FOLLOW_56); 

            					newLeafNode(lv_active_10_0, grammarAccess.getKnowledgeAccess().getActiveINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKnowledgeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"active",
            						lv_active_10_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalGames.g:1836:3: (otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalGames.g:1837:4: otherlv_11= 'conditionsActive' ( (lv_conditionsActive_12_0= ruleCondition ) )*
                    {
                    otherlv_11=(Token)match(input,33,FOLLOW_57); 

                    				newLeafNode(otherlv_11, grammarAccess.getKnowledgeAccess().getConditionsActiveKeyword_10_0());
                    			
                    // InternalGames.g:1841:4: ( (lv_conditionsActive_12_0= ruleCondition ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==54) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalGames.g:1842:5: (lv_conditionsActive_12_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1842:5: (lv_conditionsActive_12_0= ruleCondition )
                    	    // InternalGames.g:1843:6: lv_conditionsActive_12_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getKnowledgeAccess().getConditionsActiveConditionParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_57);
                    	    lv_conditionsActive_12_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getKnowledgeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsActive",
                    	    							lv_conditionsActive_12_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1861:3: (otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalGames.g:1862:4: otherlv_13= 'conditionsGive' ( (lv_conditionsGive_14_0= ruleCondition ) )*
                    {
                    otherlv_13=(Token)match(input,44,FOLLOW_50); 

                    				newLeafNode(otherlv_13, grammarAccess.getKnowledgeAccess().getConditionsGiveKeyword_11_0());
                    			
                    // InternalGames.g:1866:4: ( (lv_conditionsGive_14_0= ruleCondition ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==54) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalGames.g:1867:5: (lv_conditionsGive_14_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:1867:5: (lv_conditionsGive_14_0= ruleCondition )
                    	    // InternalGames.g:1868:6: lv_conditionsGive_14_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getKnowledgeAccess().getConditionsGiveConditionParserRuleCall_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_conditionsGive_14_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getKnowledgeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsGive",
                    	    							lv_conditionsGive_14_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getKnowledgeAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKnowledge"


    // $ANTLR start "entryRulePlace"
    // InternalGames.g:1894:1: entryRulePlace returns [EObject current=null] : iv_rulePlace= rulePlace EOF ;
    public final EObject entryRulePlace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlace = null;


        try {
            // InternalGames.g:1894:46: (iv_rulePlace= rulePlace EOF )
            // InternalGames.g:1895:2: iv_rulePlace= rulePlace EOF
            {
             newCompositeNode(grammarAccess.getPlaceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlace=rulePlace();

            state._fsp--;

             current =iv_rulePlace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlace"


    // $ANTLR start "rulePlace"
    // InternalGames.g:1901:1: rulePlace returns [EObject current=null] : (otherlv_0= 'place' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )? (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )? otherlv_11= '}' ) ;
    public final EObject rulePlace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_objects_10_0 = null;



        	enterRule();

        try {
            // InternalGames.g:1907:2: ( (otherlv_0= 'place' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )? (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )? otherlv_11= '}' ) )
            // InternalGames.g:1908:2: (otherlv_0= 'place' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )? (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )? otherlv_11= '}' )
            {
            // InternalGames.g:1908:2: (otherlv_0= 'place' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )? (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )? otherlv_11= '}' )
            // InternalGames.g:1909:3: otherlv_0= 'place' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )? (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPlaceAccess().getPlaceKeyword_0());
            		
            // InternalGames.g:1913:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:1914:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:1914:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:1915:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPlaceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlaceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_58); 

            			newLeafNode(otherlv_2, grammarAccess.getPlaceAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGames.g:1935:3: (otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==17) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalGames.g:1936:4: otherlv_3= 'knowledge' ( (otherlv_4= RULE_ID ) )*
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getPlaceAccess().getKnowledgeKeyword_3_0());
                    			
                    // InternalGames.g:1940:4: ( (otherlv_4= RULE_ID ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalGames.g:1941:5: (otherlv_4= RULE_ID )
                    	    {
                    	    // InternalGames.g:1941:5: (otherlv_4= RULE_ID )
                    	    // InternalGames.g:1942:6: otherlv_4= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPlaceRule());
                    	    						}
                    	    					
                    	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_59); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getPlaceAccess().getKnowledgesKnowledgeCrossReference_3_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1954:3: (otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==18) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalGames.g:1955:4: otherlv_5= 'people' ( (otherlv_6= RULE_ID ) )*
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_60); 

                    				newLeafNode(otherlv_5, grammarAccess.getPlaceAccess().getPeopleKeyword_4_0());
                    			
                    // InternalGames.g:1959:4: ( (otherlv_6= RULE_ID ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ID) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalGames.g:1960:5: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalGames.g:1960:5: (otherlv_6= RULE_ID )
                    	    // InternalGames.g:1961:6: otherlv_6= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPlaceRule());
                    	    						}
                    	    					
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_60); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getPlaceAccess().getPeoplePeopleCrossReference_4_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1973:3: (otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==53) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalGames.g:1974:4: otherlv_7= 'paths' ( (otherlv_8= RULE_ID ) )*
                    {
                    otherlv_7=(Token)match(input,53,FOLLOW_61); 

                    				newLeafNode(otherlv_7, grammarAccess.getPlaceAccess().getPathsKeyword_5_0());
                    			
                    // InternalGames.g:1978:4: ( (otherlv_8= RULE_ID ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_ID) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalGames.g:1979:5: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalGames.g:1979:5: (otherlv_8= RULE_ID )
                    	    // InternalGames.g:1980:6: otherlv_8= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPlaceRule());
                    	    						}
                    	    					
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_61); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getPlaceAccess().getPathsPathCrossReference_5_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:1992:3: (otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==19) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalGames.g:1993:4: otherlv_9= 'items' ( (lv_objects_10_0= ruleItemInSomething ) )*
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_26); 

                    				newLeafNode(otherlv_9, grammarAccess.getPlaceAccess().getItemsKeyword_6_0());
                    			
                    // InternalGames.g:1997:4: ( (lv_objects_10_0= ruleItemInSomething ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==RULE_ID) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalGames.g:1998:5: (lv_objects_10_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:1998:5: (lv_objects_10_0= ruleItemInSomething )
                    	    // InternalGames.g:1999:6: lv_objects_10_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getPlaceAccess().getObjectsItemInSomethingParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_objects_10_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPlaceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"objects",
                    	    							lv_objects_10_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getPlaceAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlace"


    // $ANTLR start "entryRuleItemInCondition"
    // InternalGames.g:2025:1: entryRuleItemInCondition returns [EObject current=null] : iv_ruleItemInCondition= ruleItemInCondition EOF ;
    public final EObject entryRuleItemInCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleItemInCondition = null;


        try {
            // InternalGames.g:2025:56: (iv_ruleItemInCondition= ruleItemInCondition EOF )
            // InternalGames.g:2026:2: iv_ruleItemInCondition= ruleItemInCondition EOF
            {
             newCompositeNode(grammarAccess.getItemInConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleItemInCondition=ruleItemInCondition();

            state._fsp--;

             current =iv_ruleItemInCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleItemInCondition"


    // $ANTLR start "ruleItemInCondition"
    // InternalGames.g:2032:1: ruleItemInCondition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_quantity_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_mustBeExact_4_0= RULE_INT ) ) ) ;
    public final EObject ruleItemInCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_quantity_2_0=null;
        Token otherlv_3=null;
        Token lv_mustBeExact_4_0=null;


        	enterRule();

        try {
            // InternalGames.g:2038:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_quantity_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_mustBeExact_4_0= RULE_INT ) ) ) )
            // InternalGames.g:2039:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_quantity_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_mustBeExact_4_0= RULE_INT ) ) )
            {
            // InternalGames.g:2039:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_quantity_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_mustBeExact_4_0= RULE_INT ) ) )
            // InternalGames.g:2040:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_quantity_2_0= RULE_INT ) ) otherlv_3= ':' ( (lv_mustBeExact_4_0= RULE_INT ) )
            {
            // InternalGames.g:2040:3: ( (otherlv_0= RULE_ID ) )
            // InternalGames.g:2041:4: (otherlv_0= RULE_ID )
            {
            // InternalGames.g:2041:4: (otherlv_0= RULE_ID )
            // InternalGames.g:2042:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemInConditionRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(otherlv_0, grammarAccess.getItemInConditionAccess().getItemItemCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getItemInConditionAccess().getColonKeyword_1());
            		
            // InternalGames.g:2057:3: ( (lv_quantity_2_0= RULE_INT ) )
            // InternalGames.g:2058:4: (lv_quantity_2_0= RULE_INT )
            {
            // InternalGames.g:2058:4: (lv_quantity_2_0= RULE_INT )
            // InternalGames.g:2059:5: lv_quantity_2_0= RULE_INT
            {
            lv_quantity_2_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            					newLeafNode(lv_quantity_2_0, grammarAccess.getItemInConditionAccess().getQuantityINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemInConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantity",
            						lv_quantity_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getItemInConditionAccess().getColonKeyword_3());
            		
            // InternalGames.g:2079:3: ( (lv_mustBeExact_4_0= RULE_INT ) )
            // InternalGames.g:2080:4: (lv_mustBeExact_4_0= RULE_INT )
            {
            // InternalGames.g:2080:4: (lv_mustBeExact_4_0= RULE_INT )
            // InternalGames.g:2081:5: lv_mustBeExact_4_0= RULE_INT
            {
            lv_mustBeExact_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_mustBeExact_4_0, grammarAccess.getItemInConditionAccess().getMustBeExactINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getItemInConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"mustBeExact",
            						lv_mustBeExact_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleItemInCondition"


    // $ANTLR start "entryRuleCondition"
    // InternalGames.g:2101:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalGames.g:2101:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalGames.g:2102:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalGames.g:2108:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'condition' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'player' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_item_8_0 = null;



        	enterRule();

        try {
            // InternalGames.g:2114:2: ( (otherlv_0= 'condition' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'player' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )? otherlv_9= '}' ) )
            // InternalGames.g:2115:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'player' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )? otherlv_9= '}' )
            {
            // InternalGames.g:2115:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'player' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )? otherlv_9= '}' )
            // InternalGames.g:2116:3: otherlv_0= 'condition' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'player' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )? (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            // InternalGames.g:2120:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalGames.g:2121:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalGames.g:2121:4: (lv_name_1_0= RULE_STRING )
            // InternalGames.g:2122:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConditionAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getPlayerKeyword_3());
            		
            // InternalGames.g:2146:3: ( (otherlv_4= RULE_ID ) )
            // InternalGames.g:2147:4: (otherlv_4= RULE_ID )
            {
            // InternalGames.g:2147:4: (otherlv_4= RULE_ID )
            // InternalGames.g:2148:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_4, grammarAccess.getConditionAccess().getPlayerPlayerCrossReference_4_0());
            				

            }


            }

            // InternalGames.g:2159:3: (otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==17) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalGames.g:2160:4: otherlv_5= 'knowledge' ( (otherlv_6= RULE_ID ) )*
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_61); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getKnowledgeKeyword_5_0());
                    			
                    // InternalGames.g:2164:4: ( (otherlv_6= RULE_ID ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==RULE_ID) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalGames.g:2165:5: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalGames.g:2165:5: (otherlv_6= RULE_ID )
                    	    // InternalGames.g:2166:6: otherlv_6= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getConditionRule());
                    	    						}
                    	    					
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_61); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getConditionAccess().getKnowKnowledgeCrossReference_5_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:2178:3: (otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==19) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalGames.g:2179:4: otherlv_7= 'items' ( (lv_item_8_0= ruleItemInCondition ) )*
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_26); 

                    				newLeafNode(otherlv_7, grammarAccess.getConditionAccess().getItemsKeyword_6_0());
                    			
                    // InternalGames.g:2183:4: ( (lv_item_8_0= ruleItemInCondition ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==RULE_ID) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalGames.g:2184:5: (lv_item_8_0= ruleItemInCondition )
                    	    {
                    	    // InternalGames.g:2184:5: (lv_item_8_0= ruleItemInCondition )
                    	    // InternalGames.g:2185:6: lv_item_8_0= ruleItemInCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getConditionAccess().getItemItemInConditionParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_item_8_0=ruleItemInCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getConditionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"item",
                    	    							lv_item_8_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInCondition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleAction"
    // InternalGames.g:2211:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalGames.g:2211:47: (iv_ruleAction= ruleAction EOF )
            // InternalGames.g:2212:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalGames.g:2218:1: ruleAction returns [EObject current=null] : (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_val_4_0= ruleActions ) ) otherlv_5= 'nextInteraction' ( (lv_interSuivante_6_0= ruleInteraction ) )? (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )? (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )? (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )? otherlv_15= 'game' ( (otherlv_16= RULE_ID ) ) otherlv_17= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Enumerator lv_val_4_0 = null;

        EObject lv_interSuivante_6_0 = null;

        EObject lv_itemsGiven_10_0 = null;

        EObject lv_itemsConsumed_12_0 = null;

        EObject lv_conditionsActionsAvailable_14_0 = null;



        	enterRule();

        try {
            // InternalGames.g:2224:2: ( (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_val_4_0= ruleActions ) ) otherlv_5= 'nextInteraction' ( (lv_interSuivante_6_0= ruleInteraction ) )? (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )? (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )? (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )? otherlv_15= 'game' ( (otherlv_16= RULE_ID ) ) otherlv_17= '}' ) )
            // InternalGames.g:2225:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_val_4_0= ruleActions ) ) otherlv_5= 'nextInteraction' ( (lv_interSuivante_6_0= ruleInteraction ) )? (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )? (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )? (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )? otherlv_15= 'game' ( (otherlv_16= RULE_ID ) ) otherlv_17= '}' )
            {
            // InternalGames.g:2225:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_val_4_0= ruleActions ) ) otherlv_5= 'nextInteraction' ( (lv_interSuivante_6_0= ruleInteraction ) )? (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )? (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )? (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )? otherlv_15= 'game' ( (otherlv_16= RULE_ID ) ) otherlv_17= '}' )
            // InternalGames.g:2226:3: otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'value' ( (lv_val_4_0= ruleActions ) ) otherlv_5= 'nextInteraction' ( (lv_interSuivante_6_0= ruleInteraction ) )? (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )? (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )? (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )? (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )? otherlv_15= 'game' ( (otherlv_16= RULE_ID ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            // InternalGames.g:2230:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGames.g:2231:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGames.g:2231:4: (lv_name_1_0= RULE_ID )
            // InternalGames.g:2232:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_62); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,56,FOLLOW_63); 

            			newLeafNode(otherlv_3, grammarAccess.getActionAccess().getValueKeyword_3());
            		
            // InternalGames.g:2256:3: ( (lv_val_4_0= ruleActions ) )
            // InternalGames.g:2257:4: (lv_val_4_0= ruleActions )
            {
            // InternalGames.g:2257:4: (lv_val_4_0= ruleActions )
            // InternalGames.g:2258:5: lv_val_4_0= ruleActions
            {

            					newCompositeNode(grammarAccess.getActionAccess().getValActionsEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_64);
            lv_val_4_0=ruleActions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_4_0,
            						"fr.enseeiht.gls.projet404.Games.Actions");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,57,FOLLOW_65); 

            			newLeafNode(otherlv_5, grammarAccess.getActionAccess().getNextInteractionKeyword_5());
            		
            // InternalGames.g:2279:3: ( (lv_interSuivante_6_0= ruleInteraction ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==60) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalGames.g:2280:4: (lv_interSuivante_6_0= ruleInteraction )
                    {
                    // InternalGames.g:2280:4: (lv_interSuivante_6_0= ruleInteraction )
                    // InternalGames.g:2281:5: lv_interSuivante_6_0= ruleInteraction
                    {

                    					newCompositeNode(grammarAccess.getActionAccess().getInterSuivanteInteractionParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_66);
                    lv_interSuivante_6_0=ruleInteraction();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActionRule());
                    					}
                    					set(
                    						current,
                    						"interSuivante",
                    						lv_interSuivante_6_0,
                    						"fr.enseeiht.gls.projet404.Games.Interaction");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalGames.g:2298:3: (otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==58) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalGames.g:2299:4: otherlv_7= 'knowledgeGiven' ( (otherlv_8= RULE_ID ) )*
                    {
                    otherlv_7=(Token)match(input,58,FOLLOW_67); 

                    				newLeafNode(otherlv_7, grammarAccess.getActionAccess().getKnowledgeGivenKeyword_7_0());
                    			
                    // InternalGames.g:2303:4: ( (otherlv_8= RULE_ID ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalGames.g:2304:5: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalGames.g:2304:5: (otherlv_8= RULE_ID )
                    	    // InternalGames.g:2305:6: otherlv_8= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getActionRule());
                    	    						}
                    	    					
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_67); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getActionAccess().getKnowledgeGivenKnowledgeCrossReference_7_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:2317:3: (otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==38) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalGames.g:2318:4: otherlv_9= 'itemsGiven' ( (lv_itemsGiven_10_0= ruleItemInSomething ) )*
                    {
                    otherlv_9=(Token)match(input,38,FOLLOW_68); 

                    				newLeafNode(otherlv_9, grammarAccess.getActionAccess().getItemsGivenKeyword_8_0());
                    			
                    // InternalGames.g:2322:4: ( (lv_itemsGiven_10_0= ruleItemInSomething ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalGames.g:2323:5: (lv_itemsGiven_10_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:2323:5: (lv_itemsGiven_10_0= ruleItemInSomething )
                    	    // InternalGames.g:2324:6: lv_itemsGiven_10_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getItemsGivenItemInSomethingParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_68);
                    	    lv_itemsGiven_10_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"itemsGiven",
                    	    							lv_itemsGiven_10_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:2342:3: (otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==39) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalGames.g:2343:4: otherlv_11= 'itemsConsumed' ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )*
                    {
                    otherlv_11=(Token)match(input,39,FOLLOW_69); 

                    				newLeafNode(otherlv_11, grammarAccess.getActionAccess().getItemsConsumedKeyword_9_0());
                    			
                    // InternalGames.g:2347:4: ( (lv_itemsConsumed_12_0= ruleItemInSomething ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalGames.g:2348:5: (lv_itemsConsumed_12_0= ruleItemInSomething )
                    	    {
                    	    // InternalGames.g:2348:5: (lv_itemsConsumed_12_0= ruleItemInSomething )
                    	    // InternalGames.g:2349:6: lv_itemsConsumed_12_0= ruleItemInSomething
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getItemsConsumedItemInSomethingParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_69);
                    	    lv_itemsConsumed_12_0=ruleItemInSomething();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"itemsConsumed",
                    	    							lv_itemsConsumed_12_0,
                    	    							"fr.enseeiht.gls.projet404.Games.ItemInSomething");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:2367:3: (otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==59) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalGames.g:2368:4: otherlv_13= 'conditionsActionsAvailable' ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )*
                    {
                    otherlv_13=(Token)match(input,59,FOLLOW_70); 

                    				newLeafNode(otherlv_13, grammarAccess.getActionAccess().getConditionsActionsAvailableKeyword_10_0());
                    			
                    // InternalGames.g:2372:4: ( (lv_conditionsActionsAvailable_14_0= ruleCondition ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==54) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalGames.g:2373:5: (lv_conditionsActionsAvailable_14_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:2373:5: (lv_conditionsActionsAvailable_14_0= ruleCondition )
                    	    // InternalGames.g:2374:6: lv_conditionsActionsAvailable_14_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getActionAccess().getConditionsActionsAvailableConditionParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_70);
                    	    lv_conditionsActionsAvailable_14_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsActionsAvailable",
                    	    							lv_conditionsActionsAvailable_14_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getActionAccess().getGameKeyword_11());
            		
            // InternalGames.g:2396:3: ( (otherlv_16= RULE_ID ) )
            // InternalGames.g:2397:4: (otherlv_16= RULE_ID )
            {
            // InternalGames.g:2397:4: (otherlv_16= RULE_ID )
            // InternalGames.g:2398:5: otherlv_16= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            				
            otherlv_16=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_16, grammarAccess.getActionAccess().getGameGameCrossReference_12_0());
            				

            }


            }

            otherlv_17=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleInteraction"
    // InternalGames.g:2417:1: entryRuleInteraction returns [EObject current=null] : iv_ruleInteraction= ruleInteraction EOF ;
    public final EObject entryRuleInteraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteraction = null;


        try {
            // InternalGames.g:2417:52: (iv_ruleInteraction= ruleInteraction EOF )
            // InternalGames.g:2418:2: iv_ruleInteraction= ruleInteraction EOF
            {
             newCompositeNode(grammarAccess.getInteractionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteraction=ruleInteraction();

            state._fsp--;

             current =iv_ruleInteraction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteraction"


    // $ANTLR start "ruleInteraction"
    // InternalGames.g:2424:1: ruleInteraction returns [EObject current=null] : (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'propositions' otherlv_4= '{' ( (lv_prop_5_0= ruleProposition ) )* otherlv_6= '}' (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )? (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleInteraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_prop_5_0 = null;

        EObject lv_conditionsBegin_8_0 = null;

        EObject lv_conditionsEnd_10_0 = null;



        	enterRule();

        try {
            // InternalGames.g:2430:2: ( (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'propositions' otherlv_4= '{' ( (lv_prop_5_0= ruleProposition ) )* otherlv_6= '}' (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )? (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )? otherlv_11= '}' ) )
            // InternalGames.g:2431:2: (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'propositions' otherlv_4= '{' ( (lv_prop_5_0= ruleProposition ) )* otherlv_6= '}' (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )? (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )? otherlv_11= '}' )
            {
            // InternalGames.g:2431:2: (otherlv_0= 'interaction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'propositions' otherlv_4= '{' ( (lv_prop_5_0= ruleProposition ) )* otherlv_6= '}' (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )? (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )? otherlv_11= '}' )
            // InternalGames.g:2432:3: otherlv_0= 'interaction' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' otherlv_3= 'propositions' otherlv_4= '{' ( (lv_prop_5_0= ruleProposition ) )* otherlv_6= '}' (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )? (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getInteractionAccess().getInteractionKeyword_0());
            		
            // InternalGames.g:2436:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalGames.g:2437:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalGames.g:2437:4: (lv_name_1_0= RULE_STRING )
            // InternalGames.g:2438:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInteractionAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInteractionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_71); 

            			newLeafNode(otherlv_2, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,61,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getInteractionAccess().getPropositionsKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_72); 

            			newLeafNode(otherlv_4, grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalGames.g:2466:3: ( (lv_prop_5_0= ruleProposition ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==64) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalGames.g:2467:4: (lv_prop_5_0= ruleProposition )
            	    {
            	    // InternalGames.g:2467:4: (lv_prop_5_0= ruleProposition )
            	    // InternalGames.g:2468:5: lv_prop_5_0= ruleProposition
            	    {

            	    					newCompositeNode(grammarAccess.getInteractionAccess().getPropPropositionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_72);
            	    lv_prop_5_0=ruleProposition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInteractionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"prop",
            	    						lv_prop_5_0,
            	    						"fr.enseeiht.gls.projet404.Games.Proposition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_6=(Token)match(input,27,FOLLOW_73); 

            			newLeafNode(otherlv_6, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_6());
            		
            // InternalGames.g:2489:3: (otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==62) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalGames.g:2490:4: otherlv_7= 'conditionsBegin' ( (lv_conditionsBegin_8_0= ruleCondition ) )*
                    {
                    otherlv_7=(Token)match(input,62,FOLLOW_74); 

                    				newLeafNode(otherlv_7, grammarAccess.getInteractionAccess().getConditionsBeginKeyword_7_0());
                    			
                    // InternalGames.g:2494:4: ( (lv_conditionsBegin_8_0= ruleCondition ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==54) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalGames.g:2495:5: (lv_conditionsBegin_8_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:2495:5: (lv_conditionsBegin_8_0= ruleCondition )
                    	    // InternalGames.g:2496:6: lv_conditionsBegin_8_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getInteractionAccess().getConditionsBeginConditionParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_74);
                    	    lv_conditionsBegin_8_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsBegin",
                    	    							lv_conditionsBegin_8_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGames.g:2514:3: (otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==63) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalGames.g:2515:4: otherlv_9= 'conditionsEnd' ( (lv_conditionsEnd_10_0= ruleCondition ) )*
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_50); 

                    				newLeafNode(otherlv_9, grammarAccess.getInteractionAccess().getConditionsEndKeyword_8_0());
                    			
                    // InternalGames.g:2519:4: ( (lv_conditionsEnd_10_0= ruleCondition ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==54) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalGames.g:2520:5: (lv_conditionsEnd_10_0= ruleCondition )
                    	    {
                    	    // InternalGames.g:2520:5: (lv_conditionsEnd_10_0= ruleCondition )
                    	    // InternalGames.g:2521:6: lv_conditionsEnd_10_0= ruleCondition
                    	    {

                    	    						newCompositeNode(grammarAccess.getInteractionAccess().getConditionsEndConditionParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_conditionsEnd_10_0=ruleCondition();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInteractionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"conditionsEnd",
                    	    							lv_conditionsEnd_10_0,
                    	    							"fr.enseeiht.gls.projet404.Games.Condition");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteraction"


    // $ANTLR start "entryRuleProposition"
    // InternalGames.g:2547:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalGames.g:2547:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalGames.g:2548:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalGames.g:2554:1: ruleProposition returns [EObject current=null] : (otherlv_0= 'proposition' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) ( (lv_act_4_0= ruleAction ) ) otherlv_5= '}' ) ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_5=null;
        EObject lv_act_4_0 = null;



        	enterRule();

        try {
            // InternalGames.g:2560:2: ( (otherlv_0= 'proposition' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) ( (lv_act_4_0= ruleAction ) ) otherlv_5= '}' ) )
            // InternalGames.g:2561:2: (otherlv_0= 'proposition' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) ( (lv_act_4_0= ruleAction ) ) otherlv_5= '}' )
            {
            // InternalGames.g:2561:2: (otherlv_0= 'proposition' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) ( (lv_act_4_0= ruleAction ) ) otherlv_5= '}' )
            // InternalGames.g:2562:3: otherlv_0= 'proposition' otherlv_1= '{' otherlv_2= 'value' ( (lv_value_3_0= RULE_STRING ) ) ( (lv_act_4_0= ruleAction ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getPropositionAccess().getPropositionKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getPropositionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,56,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getPropositionAccess().getValueKeyword_2());
            		
            // InternalGames.g:2574:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalGames.g:2575:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalGames.g:2575:4: (lv_value_3_0= RULE_STRING )
            // InternalGames.g:2576:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_75); 

            					newLeafNode(lv_value_3_0, grammarAccess.getPropositionAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropositionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGames.g:2592:3: ( (lv_act_4_0= ruleAction ) )
            // InternalGames.g:2593:4: (lv_act_4_0= ruleAction )
            {
            // InternalGames.g:2593:4: (lv_act_4_0= ruleAction )
            // InternalGames.g:2594:5: lv_act_4_0= ruleAction
            {

            					newCompositeNode(grammarAccess.getPropositionAccess().getActActionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_36);
            lv_act_4_0=ruleAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropositionRule());
            					}
            					set(
            						current,
            						"act",
            						lv_act_4_0,
            						"fr.enseeiht.gls.projet404.Games.Action");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPropositionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "ruleActions"
    // InternalGames.g:2619:1: ruleActions returns [Enumerator current=null] : ( (enumLiteral_0= 'TAKE_PATH' ) | (enumLiteral_1= 'TAKE_ITEM' ) | (enumLiteral_2= 'LEARN_KNOWLEDGE' ) | (enumLiteral_3= 'QUIT' ) | (enumLiteral_4= 'CONSUME_ITEM' ) ) ;
    public final Enumerator ruleActions() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalGames.g:2625:2: ( ( (enumLiteral_0= 'TAKE_PATH' ) | (enumLiteral_1= 'TAKE_ITEM' ) | (enumLiteral_2= 'LEARN_KNOWLEDGE' ) | (enumLiteral_3= 'QUIT' ) | (enumLiteral_4= 'CONSUME_ITEM' ) ) )
            // InternalGames.g:2626:2: ( (enumLiteral_0= 'TAKE_PATH' ) | (enumLiteral_1= 'TAKE_ITEM' ) | (enumLiteral_2= 'LEARN_KNOWLEDGE' ) | (enumLiteral_3= 'QUIT' ) | (enumLiteral_4= 'CONSUME_ITEM' ) )
            {
            // InternalGames.g:2626:2: ( (enumLiteral_0= 'TAKE_PATH' ) | (enumLiteral_1= 'TAKE_ITEM' ) | (enumLiteral_2= 'LEARN_KNOWLEDGE' ) | (enumLiteral_3= 'QUIT' ) | (enumLiteral_4= 'CONSUME_ITEM' ) )
            int alt79=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt79=1;
                }
                break;
            case 66:
                {
                alt79=2;
                }
                break;
            case 67:
                {
                alt79=3;
                }
                break;
            case 68:
                {
                alt79=4;
                }
                break;
            case 69:
                {
                alt79=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalGames.g:2627:3: (enumLiteral_0= 'TAKE_PATH' )
                    {
                    // InternalGames.g:2627:3: (enumLiteral_0= 'TAKE_PATH' )
                    // InternalGames.g:2628:4: enumLiteral_0= 'TAKE_PATH'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getActionsAccess().getPRENDRE_CHEMINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActionsAccess().getPRENDRE_CHEMINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGames.g:2635:3: (enumLiteral_1= 'TAKE_ITEM' )
                    {
                    // InternalGames.g:2635:3: (enumLiteral_1= 'TAKE_ITEM' )
                    // InternalGames.g:2636:4: enumLiteral_1= 'TAKE_ITEM'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getActionsAccess().getPRENDRE_OBJETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActionsAccess().getPRENDRE_OBJETEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGames.g:2643:3: (enumLiteral_2= 'LEARN_KNOWLEDGE' )
                    {
                    // InternalGames.g:2643:3: (enumLiteral_2= 'LEARN_KNOWLEDGE' )
                    // InternalGames.g:2644:4: enumLiteral_2= 'LEARN_KNOWLEDGE'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getActionsAccess().getAPPRENDRE_CONNAISSANCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActionsAccess().getAPPRENDRE_CONNAISSANCEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGames.g:2651:3: (enumLiteral_3= 'QUIT' )
                    {
                    // InternalGames.g:2651:3: (enumLiteral_3= 'QUIT' )
                    // InternalGames.g:2652:4: enumLiteral_3= 'QUIT'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getActionsAccess().getQUITTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getActionsAccess().getQUITTEREnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGames.g:2659:3: (enumLiteral_4= 'CONSUME_ITEM' )
                    {
                    // InternalGames.g:2659:3: (enumLiteral_4= 'CONSUME_ITEM' )
                    // InternalGames.g:2660:4: enumLiteral_4= 'CONSUME_ITEM'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getActionsAccess().getCONSOMMER_OBJETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getActionsAccess().getCONSOMMER_OBJETEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActions"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000000080A0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008020010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0040000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0040000400000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1000000008000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000000E008000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x000000C008000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000008008000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0040040000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000380008000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040300008000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0040200008000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0040000008000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000C000000000010L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0048000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000100208000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0040100008000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x00200000080E0000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00200000080C0010L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0020000008080010L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000008080010L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1C0000C000000800L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0C0000C000000800L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x080000C000000810L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0800008000000810L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0800000000000810L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0040000000000800L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xC000000008000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x8040000008000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0080000000000000L});

}