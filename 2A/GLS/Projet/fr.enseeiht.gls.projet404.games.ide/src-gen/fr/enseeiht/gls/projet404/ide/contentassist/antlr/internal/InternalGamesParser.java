package fr.enseeiht.gls.projet404.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.enseeiht.gls.projet404.services.GamesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGamesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'TAKE_PATH'", "'TAKE_ITEM'", "'LEARN_KNOWLEDGE'", "'QUIT'", "'CONSUME_ITEM'", "'game'", "':'", "'places'", "'['", "']'", "'people'", "'path'", "'startPlace'", "'endPlace'", "','", "'knowledge'", "'items'", "'recipes'", "'difficulty'", "'{'", "'sizeMax'", "'}'", "'player'", "'description'", "'visible'", "'active'", "'isMandatory'", "'conditionsVisible'", "'conditionsActive'", "'isOpen'", "'conditionsOpen'", "'knowledgesGiven'", "'itemsGiven'", "'itemsConsumed'", "'item'", "'size'", "'canPutDown'", "'conditionsPutDown'", "'conditionsGive'", "'conditionsConsumed'", "'('", "')'", "'recipe'", "'itemsUsed'", "'itemsMade'", "'conditions'", "'place'", "'paths'", "'condition'", "'action'", "'value'", "'nextInteraction'", "'knowledgeGiven'", "'conditionsActionsAvailable'", "'interaction'", "'propositions'", "'conditionsBegin'", "'conditionsEnd'", "'proposition'"
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

    	public void setGrammarAccess(GamesGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleGame"
    // InternalGames.g:53:1: entryRuleGame : ruleGame EOF ;
    public final void entryRuleGame() throws RecognitionException {
        try {
            // InternalGames.g:54:1: ( ruleGame EOF )
            // InternalGames.g:55:1: ruleGame EOF
            {
             before(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            ruleGame();

            state._fsp--;

             after(grammarAccess.getGameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalGames.g:62:1: ruleGame : ( ( rule__Game__Group__0 ) ) ;
    public final void ruleGame() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:66:2: ( ( ( rule__Game__Group__0 ) ) )
            // InternalGames.g:67:2: ( ( rule__Game__Group__0 ) )
            {
            // InternalGames.g:67:2: ( ( rule__Game__Group__0 ) )
            // InternalGames.g:68:3: ( rule__Game__Group__0 )
            {
             before(grammarAccess.getGameAccess().getGroup()); 
            // InternalGames.g:69:3: ( rule__Game__Group__0 )
            // InternalGames.g:69:4: rule__Game__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleDifficulty"
    // InternalGames.g:78:1: entryRuleDifficulty : ruleDifficulty EOF ;
    public final void entryRuleDifficulty() throws RecognitionException {
        try {
            // InternalGames.g:79:1: ( ruleDifficulty EOF )
            // InternalGames.g:80:1: ruleDifficulty EOF
            {
             before(grammarAccess.getDifficultyRule()); 
            pushFollow(FOLLOW_1);
            ruleDifficulty();

            state._fsp--;

             after(grammarAccess.getDifficultyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDifficulty"


    // $ANTLR start "ruleDifficulty"
    // InternalGames.g:87:1: ruleDifficulty : ( ( rule__Difficulty__Group__0 ) ) ;
    public final void ruleDifficulty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:91:2: ( ( ( rule__Difficulty__Group__0 ) ) )
            // InternalGames.g:92:2: ( ( rule__Difficulty__Group__0 ) )
            {
            // InternalGames.g:92:2: ( ( rule__Difficulty__Group__0 ) )
            // InternalGames.g:93:3: ( rule__Difficulty__Group__0 )
            {
             before(grammarAccess.getDifficultyAccess().getGroup()); 
            // InternalGames.g:94:3: ( rule__Difficulty__Group__0 )
            // InternalGames.g:94:4: rule__Difficulty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDifficultyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDifficulty"


    // $ANTLR start "entryRulePlayer"
    // InternalGames.g:103:1: entryRulePlayer : rulePlayer EOF ;
    public final void entryRulePlayer() throws RecognitionException {
        try {
            // InternalGames.g:104:1: ( rulePlayer EOF )
            // InternalGames.g:105:1: rulePlayer EOF
            {
             before(grammarAccess.getPlayerRule()); 
            pushFollow(FOLLOW_1);
            rulePlayer();

            state._fsp--;

             after(grammarAccess.getPlayerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePlayer"


    // $ANTLR start "rulePlayer"
    // InternalGames.g:112:1: rulePlayer : ( ( rule__Player__Group__0 ) ) ;
    public final void rulePlayer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:116:2: ( ( ( rule__Player__Group__0 ) ) )
            // InternalGames.g:117:2: ( ( rule__Player__Group__0 ) )
            {
            // InternalGames.g:117:2: ( ( rule__Player__Group__0 ) )
            // InternalGames.g:118:3: ( rule__Player__Group__0 )
            {
             before(grammarAccess.getPlayerAccess().getGroup()); 
            // InternalGames.g:119:3: ( rule__Player__Group__0 )
            // InternalGames.g:119:4: rule__Player__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Player__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPlayerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlayer"


    // $ANTLR start "entryRulePeople"
    // InternalGames.g:128:1: entryRulePeople : rulePeople EOF ;
    public final void entryRulePeople() throws RecognitionException {
        try {
            // InternalGames.g:129:1: ( rulePeople EOF )
            // InternalGames.g:130:1: rulePeople EOF
            {
             before(grammarAccess.getPeopleRule()); 
            pushFollow(FOLLOW_1);
            rulePeople();

            state._fsp--;

             after(grammarAccess.getPeopleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePeople"


    // $ANTLR start "rulePeople"
    // InternalGames.g:137:1: rulePeople : ( ( rule__People__Group__0 ) ) ;
    public final void rulePeople() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:141:2: ( ( ( rule__People__Group__0 ) ) )
            // InternalGames.g:142:2: ( ( rule__People__Group__0 ) )
            {
            // InternalGames.g:142:2: ( ( rule__People__Group__0 ) )
            // InternalGames.g:143:3: ( rule__People__Group__0 )
            {
             before(grammarAccess.getPeopleAccess().getGroup()); 
            // InternalGames.g:144:3: ( rule__People__Group__0 )
            // InternalGames.g:144:4: rule__People__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__People__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePeople"


    // $ANTLR start "entryRulePath"
    // InternalGames.g:153:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        try {
            // InternalGames.g:154:1: ( rulePath EOF )
            // InternalGames.g:155:1: rulePath EOF
            {
             before(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            rulePath();

            state._fsp--;

             after(grammarAccess.getPathRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalGames.g:162:1: rulePath : ( ( rule__Path__Group__0 ) ) ;
    public final void rulePath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:166:2: ( ( ( rule__Path__Group__0 ) ) )
            // InternalGames.g:167:2: ( ( rule__Path__Group__0 ) )
            {
            // InternalGames.g:167:2: ( ( rule__Path__Group__0 ) )
            // InternalGames.g:168:3: ( rule__Path__Group__0 )
            {
             before(grammarAccess.getPathAccess().getGroup()); 
            // InternalGames.g:169:3: ( rule__Path__Group__0 )
            // InternalGames.g:169:4: rule__Path__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleItem"
    // InternalGames.g:178:1: entryRuleItem : ruleItem EOF ;
    public final void entryRuleItem() throws RecognitionException {
        try {
            // InternalGames.g:179:1: ( ruleItem EOF )
            // InternalGames.g:180:1: ruleItem EOF
            {
             before(grammarAccess.getItemRule()); 
            pushFollow(FOLLOW_1);
            ruleItem();

            state._fsp--;

             after(grammarAccess.getItemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleItem"


    // $ANTLR start "ruleItem"
    // InternalGames.g:187:1: ruleItem : ( ( rule__Item__Group__0 ) ) ;
    public final void ruleItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:191:2: ( ( ( rule__Item__Group__0 ) ) )
            // InternalGames.g:192:2: ( ( rule__Item__Group__0 ) )
            {
            // InternalGames.g:192:2: ( ( rule__Item__Group__0 ) )
            // InternalGames.g:193:3: ( rule__Item__Group__0 )
            {
             before(grammarAccess.getItemAccess().getGroup()); 
            // InternalGames.g:194:3: ( rule__Item__Group__0 )
            // InternalGames.g:194:4: rule__Item__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleItem"


    // $ANTLR start "entryRuleItemInSomething"
    // InternalGames.g:203:1: entryRuleItemInSomething : ruleItemInSomething EOF ;
    public final void entryRuleItemInSomething() throws RecognitionException {
        try {
            // InternalGames.g:204:1: ( ruleItemInSomething EOF )
            // InternalGames.g:205:1: ruleItemInSomething EOF
            {
             before(grammarAccess.getItemInSomethingRule()); 
            pushFollow(FOLLOW_1);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getItemInSomethingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleItemInSomething"


    // $ANTLR start "ruleItemInSomething"
    // InternalGames.g:212:1: ruleItemInSomething : ( ( rule__ItemInSomething__Group__0 ) ) ;
    public final void ruleItemInSomething() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:216:2: ( ( ( rule__ItemInSomething__Group__0 ) ) )
            // InternalGames.g:217:2: ( ( rule__ItemInSomething__Group__0 ) )
            {
            // InternalGames.g:217:2: ( ( rule__ItemInSomething__Group__0 ) )
            // InternalGames.g:218:3: ( rule__ItemInSomething__Group__0 )
            {
             before(grammarAccess.getItemInSomethingAccess().getGroup()); 
            // InternalGames.g:219:3: ( rule__ItemInSomething__Group__0 )
            // InternalGames.g:219:4: rule__ItemInSomething__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ItemInSomething__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getItemInSomethingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleItemInSomething"


    // $ANTLR start "entryRuleRecipe"
    // InternalGames.g:228:1: entryRuleRecipe : ruleRecipe EOF ;
    public final void entryRuleRecipe() throws RecognitionException {
        try {
            // InternalGames.g:229:1: ( ruleRecipe EOF )
            // InternalGames.g:230:1: ruleRecipe EOF
            {
             before(grammarAccess.getRecipeRule()); 
            pushFollow(FOLLOW_1);
            ruleRecipe();

            state._fsp--;

             after(grammarAccess.getRecipeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRecipe"


    // $ANTLR start "ruleRecipe"
    // InternalGames.g:237:1: ruleRecipe : ( ( rule__Recipe__Group__0 ) ) ;
    public final void ruleRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:241:2: ( ( ( rule__Recipe__Group__0 ) ) )
            // InternalGames.g:242:2: ( ( rule__Recipe__Group__0 ) )
            {
            // InternalGames.g:242:2: ( ( rule__Recipe__Group__0 ) )
            // InternalGames.g:243:3: ( rule__Recipe__Group__0 )
            {
             before(grammarAccess.getRecipeAccess().getGroup()); 
            // InternalGames.g:244:3: ( rule__Recipe__Group__0 )
            // InternalGames.g:244:4: rule__Recipe__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Recipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecipeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecipe"


    // $ANTLR start "entryRuleKnowledge"
    // InternalGames.g:253:1: entryRuleKnowledge : ruleKnowledge EOF ;
    public final void entryRuleKnowledge() throws RecognitionException {
        try {
            // InternalGames.g:254:1: ( ruleKnowledge EOF )
            // InternalGames.g:255:1: ruleKnowledge EOF
            {
             before(grammarAccess.getKnowledgeRule()); 
            pushFollow(FOLLOW_1);
            ruleKnowledge();

            state._fsp--;

             after(grammarAccess.getKnowledgeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKnowledge"


    // $ANTLR start "ruleKnowledge"
    // InternalGames.g:262:1: ruleKnowledge : ( ( rule__Knowledge__Group__0 ) ) ;
    public final void ruleKnowledge() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:266:2: ( ( ( rule__Knowledge__Group__0 ) ) )
            // InternalGames.g:267:2: ( ( rule__Knowledge__Group__0 ) )
            {
            // InternalGames.g:267:2: ( ( rule__Knowledge__Group__0 ) )
            // InternalGames.g:268:3: ( rule__Knowledge__Group__0 )
            {
             before(grammarAccess.getKnowledgeAccess().getGroup()); 
            // InternalGames.g:269:3: ( rule__Knowledge__Group__0 )
            // InternalGames.g:269:4: rule__Knowledge__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKnowledgeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKnowledge"


    // $ANTLR start "entryRulePlace"
    // InternalGames.g:278:1: entryRulePlace : rulePlace EOF ;
    public final void entryRulePlace() throws RecognitionException {
        try {
            // InternalGames.g:279:1: ( rulePlace EOF )
            // InternalGames.g:280:1: rulePlace EOF
            {
             before(grammarAccess.getPlaceRule()); 
            pushFollow(FOLLOW_1);
            rulePlace();

            state._fsp--;

             after(grammarAccess.getPlaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePlace"


    // $ANTLR start "rulePlace"
    // InternalGames.g:287:1: rulePlace : ( ( rule__Place__Group__0 ) ) ;
    public final void rulePlace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:291:2: ( ( ( rule__Place__Group__0 ) ) )
            // InternalGames.g:292:2: ( ( rule__Place__Group__0 ) )
            {
            // InternalGames.g:292:2: ( ( rule__Place__Group__0 ) )
            // InternalGames.g:293:3: ( rule__Place__Group__0 )
            {
             before(grammarAccess.getPlaceAccess().getGroup()); 
            // InternalGames.g:294:3: ( rule__Place__Group__0 )
            // InternalGames.g:294:4: rule__Place__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPlaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlace"


    // $ANTLR start "entryRuleItemInCondition"
    // InternalGames.g:303:1: entryRuleItemInCondition : ruleItemInCondition EOF ;
    public final void entryRuleItemInCondition() throws RecognitionException {
        try {
            // InternalGames.g:304:1: ( ruleItemInCondition EOF )
            // InternalGames.g:305:1: ruleItemInCondition EOF
            {
             before(grammarAccess.getItemInConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleItemInCondition();

            state._fsp--;

             after(grammarAccess.getItemInConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleItemInCondition"


    // $ANTLR start "ruleItemInCondition"
    // InternalGames.g:312:1: ruleItemInCondition : ( ( rule__ItemInCondition__Group__0 ) ) ;
    public final void ruleItemInCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:316:2: ( ( ( rule__ItemInCondition__Group__0 ) ) )
            // InternalGames.g:317:2: ( ( rule__ItemInCondition__Group__0 ) )
            {
            // InternalGames.g:317:2: ( ( rule__ItemInCondition__Group__0 ) )
            // InternalGames.g:318:3: ( rule__ItemInCondition__Group__0 )
            {
             before(grammarAccess.getItemInConditionAccess().getGroup()); 
            // InternalGames.g:319:3: ( rule__ItemInCondition__Group__0 )
            // InternalGames.g:319:4: rule__ItemInCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getItemInConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleItemInCondition"


    // $ANTLR start "entryRuleCondition"
    // InternalGames.g:328:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalGames.g:329:1: ( ruleCondition EOF )
            // InternalGames.g:330:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalGames.g:337:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:341:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalGames.g:342:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalGames.g:342:2: ( ( rule__Condition__Group__0 ) )
            // InternalGames.g:343:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalGames.g:344:3: ( rule__Condition__Group__0 )
            // InternalGames.g:344:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleAction"
    // InternalGames.g:353:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalGames.g:354:1: ( ruleAction EOF )
            // InternalGames.g:355:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalGames.g:362:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:366:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalGames.g:367:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalGames.g:367:2: ( ( rule__Action__Group__0 ) )
            // InternalGames.g:368:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalGames.g:369:3: ( rule__Action__Group__0 )
            // InternalGames.g:369:4: rule__Action__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleInteraction"
    // InternalGames.g:378:1: entryRuleInteraction : ruleInteraction EOF ;
    public final void entryRuleInteraction() throws RecognitionException {
        try {
            // InternalGames.g:379:1: ( ruleInteraction EOF )
            // InternalGames.g:380:1: ruleInteraction EOF
            {
             before(grammarAccess.getInteractionRule()); 
            pushFollow(FOLLOW_1);
            ruleInteraction();

            state._fsp--;

             after(grammarAccess.getInteractionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInteraction"


    // $ANTLR start "ruleInteraction"
    // InternalGames.g:387:1: ruleInteraction : ( ( rule__Interaction__Group__0 ) ) ;
    public final void ruleInteraction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:391:2: ( ( ( rule__Interaction__Group__0 ) ) )
            // InternalGames.g:392:2: ( ( rule__Interaction__Group__0 ) )
            {
            // InternalGames.g:392:2: ( ( rule__Interaction__Group__0 ) )
            // InternalGames.g:393:3: ( rule__Interaction__Group__0 )
            {
             before(grammarAccess.getInteractionAccess().getGroup()); 
            // InternalGames.g:394:3: ( rule__Interaction__Group__0 )
            // InternalGames.g:394:4: rule__Interaction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteraction"


    // $ANTLR start "entryRuleProposition"
    // InternalGames.g:403:1: entryRuleProposition : ruleProposition EOF ;
    public final void entryRuleProposition() throws RecognitionException {
        try {
            // InternalGames.g:404:1: ( ruleProposition EOF )
            // InternalGames.g:405:1: ruleProposition EOF
            {
             before(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPropositionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalGames.g:412:1: ruleProposition : ( ( rule__Proposition__Group__0 ) ) ;
    public final void ruleProposition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:416:2: ( ( ( rule__Proposition__Group__0 ) ) )
            // InternalGames.g:417:2: ( ( rule__Proposition__Group__0 ) )
            {
            // InternalGames.g:417:2: ( ( rule__Proposition__Group__0 ) )
            // InternalGames.g:418:3: ( rule__Proposition__Group__0 )
            {
             before(grammarAccess.getPropositionAccess().getGroup()); 
            // InternalGames.g:419:3: ( rule__Proposition__Group__0 )
            // InternalGames.g:419:4: rule__Proposition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "ruleActions"
    // InternalGames.g:428:1: ruleActions : ( ( rule__Actions__Alternatives ) ) ;
    public final void ruleActions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:432:1: ( ( ( rule__Actions__Alternatives ) ) )
            // InternalGames.g:433:2: ( ( rule__Actions__Alternatives ) )
            {
            // InternalGames.g:433:2: ( ( rule__Actions__Alternatives ) )
            // InternalGames.g:434:3: ( rule__Actions__Alternatives )
            {
             before(grammarAccess.getActionsAccess().getAlternatives()); 
            // InternalGames.g:435:3: ( rule__Actions__Alternatives )
            // InternalGames.g:435:4: rule__Actions__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Actions__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActions"


    // $ANTLR start "rule__Actions__Alternatives"
    // InternalGames.g:443:1: rule__Actions__Alternatives : ( ( ( 'TAKE_PATH' ) ) | ( ( 'TAKE_ITEM' ) ) | ( ( 'LEARN_KNOWLEDGE' ) ) | ( ( 'QUIT' ) ) | ( ( 'CONSUME_ITEM' ) ) );
    public final void rule__Actions__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:447:1: ( ( ( 'TAKE_PATH' ) ) | ( ( 'TAKE_ITEM' ) ) | ( ( 'LEARN_KNOWLEDGE' ) ) | ( ( 'QUIT' ) ) | ( ( 'CONSUME_ITEM' ) ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalGames.g:448:2: ( ( 'TAKE_PATH' ) )
                    {
                    // InternalGames.g:448:2: ( ( 'TAKE_PATH' ) )
                    // InternalGames.g:449:3: ( 'TAKE_PATH' )
                    {
                     before(grammarAccess.getActionsAccess().getPRENDRE_CHEMINEnumLiteralDeclaration_0()); 
                    // InternalGames.g:450:3: ( 'TAKE_PATH' )
                    // InternalGames.g:450:4: 'TAKE_PATH'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionsAccess().getPRENDRE_CHEMINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGames.g:454:2: ( ( 'TAKE_ITEM' ) )
                    {
                    // InternalGames.g:454:2: ( ( 'TAKE_ITEM' ) )
                    // InternalGames.g:455:3: ( 'TAKE_ITEM' )
                    {
                     before(grammarAccess.getActionsAccess().getPRENDRE_OBJETEnumLiteralDeclaration_1()); 
                    // InternalGames.g:456:3: ( 'TAKE_ITEM' )
                    // InternalGames.g:456:4: 'TAKE_ITEM'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionsAccess().getPRENDRE_OBJETEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGames.g:460:2: ( ( 'LEARN_KNOWLEDGE' ) )
                    {
                    // InternalGames.g:460:2: ( ( 'LEARN_KNOWLEDGE' ) )
                    // InternalGames.g:461:3: ( 'LEARN_KNOWLEDGE' )
                    {
                     before(grammarAccess.getActionsAccess().getAPPRENDRE_CONNAISSANCEEnumLiteralDeclaration_2()); 
                    // InternalGames.g:462:3: ( 'LEARN_KNOWLEDGE' )
                    // InternalGames.g:462:4: 'LEARN_KNOWLEDGE'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionsAccess().getAPPRENDRE_CONNAISSANCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGames.g:466:2: ( ( 'QUIT' ) )
                    {
                    // InternalGames.g:466:2: ( ( 'QUIT' ) )
                    // InternalGames.g:467:3: ( 'QUIT' )
                    {
                     before(grammarAccess.getActionsAccess().getQUITTEREnumLiteralDeclaration_3()); 
                    // InternalGames.g:468:3: ( 'QUIT' )
                    // InternalGames.g:468:4: 'QUIT'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionsAccess().getQUITTEREnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalGames.g:472:2: ( ( 'CONSUME_ITEM' ) )
                    {
                    // InternalGames.g:472:2: ( ( 'CONSUME_ITEM' ) )
                    // InternalGames.g:473:3: ( 'CONSUME_ITEM' )
                    {
                     before(grammarAccess.getActionsAccess().getCONSOMMER_OBJETEnumLiteralDeclaration_4()); 
                    // InternalGames.g:474:3: ( 'CONSUME_ITEM' )
                    // InternalGames.g:474:4: 'CONSUME_ITEM'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionsAccess().getCONSOMMER_OBJETEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actions__Alternatives"


    // $ANTLR start "rule__Game__Group__0"
    // InternalGames.g:482:1: rule__Game__Group__0 : rule__Game__Group__0__Impl rule__Game__Group__1 ;
    public final void rule__Game__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:486:1: ( rule__Game__Group__0__Impl rule__Game__Group__1 )
            // InternalGames.g:487:2: rule__Game__Group__0__Impl rule__Game__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0"


    // $ANTLR start "rule__Game__Group__0__Impl"
    // InternalGames.g:494:1: rule__Game__Group__0__Impl : ( 'game' ) ;
    public final void rule__Game__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:498:1: ( ( 'game' ) )
            // InternalGames.g:499:1: ( 'game' )
            {
            // InternalGames.g:499:1: ( 'game' )
            // InternalGames.g:500:2: 'game'
            {
             before(grammarAccess.getGameAccess().getGameKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getGameKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__0__Impl"


    // $ANTLR start "rule__Game__Group__1"
    // InternalGames.g:509:1: rule__Game__Group__1 : rule__Game__Group__1__Impl rule__Game__Group__2 ;
    public final void rule__Game__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:513:1: ( rule__Game__Group__1__Impl rule__Game__Group__2 )
            // InternalGames.g:514:2: rule__Game__Group__1__Impl rule__Game__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Game__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1"


    // $ANTLR start "rule__Game__Group__1__Impl"
    // InternalGames.g:521:1: rule__Game__Group__1__Impl : ( ( rule__Game__NameAssignment_1 ) ) ;
    public final void rule__Game__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:525:1: ( ( ( rule__Game__NameAssignment_1 ) ) )
            // InternalGames.g:526:1: ( ( rule__Game__NameAssignment_1 ) )
            {
            // InternalGames.g:526:1: ( ( rule__Game__NameAssignment_1 ) )
            // InternalGames.g:527:2: ( rule__Game__NameAssignment_1 )
            {
             before(grammarAccess.getGameAccess().getNameAssignment_1()); 
            // InternalGames.g:528:2: ( rule__Game__NameAssignment_1 )
            // InternalGames.g:528:3: rule__Game__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__1__Impl"


    // $ANTLR start "rule__Game__Group__2"
    // InternalGames.g:536:1: rule__Game__Group__2 : rule__Game__Group__2__Impl rule__Game__Group__3 ;
    public final void rule__Game__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:540:1: ( rule__Game__Group__2__Impl rule__Game__Group__3 )
            // InternalGames.g:541:2: rule__Game__Group__2__Impl rule__Game__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Game__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2"


    // $ANTLR start "rule__Game__Group__2__Impl"
    // InternalGames.g:548:1: rule__Game__Group__2__Impl : ( ':' ) ;
    public final void rule__Game__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:552:1: ( ( ':' ) )
            // InternalGames.g:553:1: ( ':' )
            {
            // InternalGames.g:553:1: ( ':' )
            // InternalGames.g:554:2: ':'
            {
             before(grammarAccess.getGameAccess().getColonKeyword_2()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__2__Impl"


    // $ANTLR start "rule__Game__Group__3"
    // InternalGames.g:563:1: rule__Game__Group__3 : rule__Game__Group__3__Impl rule__Game__Group__4 ;
    public final void rule__Game__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:567:1: ( rule__Game__Group__3__Impl rule__Game__Group__4 )
            // InternalGames.g:568:2: rule__Game__Group__3__Impl rule__Game__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Game__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3"


    // $ANTLR start "rule__Game__Group__3__Impl"
    // InternalGames.g:575:1: rule__Game__Group__3__Impl : ( ( rule__Game__PlayerAssignment_3 ) ) ;
    public final void rule__Game__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:579:1: ( ( ( rule__Game__PlayerAssignment_3 ) ) )
            // InternalGames.g:580:1: ( ( rule__Game__PlayerAssignment_3 ) )
            {
            // InternalGames.g:580:1: ( ( rule__Game__PlayerAssignment_3 ) )
            // InternalGames.g:581:2: ( rule__Game__PlayerAssignment_3 )
            {
             before(grammarAccess.getGameAccess().getPlayerAssignment_3()); 
            // InternalGames.g:582:2: ( rule__Game__PlayerAssignment_3 )
            // InternalGames.g:582:3: rule__Game__PlayerAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Game__PlayerAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPlayerAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__3__Impl"


    // $ANTLR start "rule__Game__Group__4"
    // InternalGames.g:590:1: rule__Game__Group__4 : rule__Game__Group__4__Impl rule__Game__Group__5 ;
    public final void rule__Game__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:594:1: ( rule__Game__Group__4__Impl rule__Game__Group__5 )
            // InternalGames.g:595:2: rule__Game__Group__4__Impl rule__Game__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4"


    // $ANTLR start "rule__Game__Group__4__Impl"
    // InternalGames.g:602:1: rule__Game__Group__4__Impl : ( 'places' ) ;
    public final void rule__Game__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:606:1: ( ( 'places' ) )
            // InternalGames.g:607:1: ( 'places' )
            {
            // InternalGames.g:607:1: ( 'places' )
            // InternalGames.g:608:2: 'places'
            {
             before(grammarAccess.getGameAccess().getPlacesKeyword_4()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getPlacesKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__4__Impl"


    // $ANTLR start "rule__Game__Group__5"
    // InternalGames.g:617:1: rule__Game__Group__5 : rule__Game__Group__5__Impl rule__Game__Group__6 ;
    public final void rule__Game__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:621:1: ( rule__Game__Group__5__Impl rule__Game__Group__6 )
            // InternalGames.g:622:2: rule__Game__Group__5__Impl rule__Game__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Game__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5"


    // $ANTLR start "rule__Game__Group__5__Impl"
    // InternalGames.g:629:1: rule__Game__Group__5__Impl : ( '[' ) ;
    public final void rule__Game__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:633:1: ( ( '[' ) )
            // InternalGames.g:634:1: ( '[' )
            {
            // InternalGames.g:634:1: ( '[' )
            // InternalGames.g:635:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__5__Impl"


    // $ANTLR start "rule__Game__Group__6"
    // InternalGames.g:644:1: rule__Game__Group__6 : rule__Game__Group__6__Impl rule__Game__Group__7 ;
    public final void rule__Game__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:648:1: ( rule__Game__Group__6__Impl rule__Game__Group__7 )
            // InternalGames.g:649:2: rule__Game__Group__6__Impl rule__Game__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__6"


    // $ANTLR start "rule__Game__Group__6__Impl"
    // InternalGames.g:656:1: rule__Game__Group__6__Impl : ( ( rule__Game__PlacesAssignment_6 ) ) ;
    public final void rule__Game__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:660:1: ( ( ( rule__Game__PlacesAssignment_6 ) ) )
            // InternalGames.g:661:1: ( ( rule__Game__PlacesAssignment_6 ) )
            {
            // InternalGames.g:661:1: ( ( rule__Game__PlacesAssignment_6 ) )
            // InternalGames.g:662:2: ( rule__Game__PlacesAssignment_6 )
            {
             before(grammarAccess.getGameAccess().getPlacesAssignment_6()); 
            // InternalGames.g:663:2: ( rule__Game__PlacesAssignment_6 )
            // InternalGames.g:663:3: rule__Game__PlacesAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Game__PlacesAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPlacesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__6__Impl"


    // $ANTLR start "rule__Game__Group__7"
    // InternalGames.g:671:1: rule__Game__Group__7 : rule__Game__Group__7__Impl rule__Game__Group__8 ;
    public final void rule__Game__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:675:1: ( rule__Game__Group__7__Impl rule__Game__Group__8 )
            // InternalGames.g:676:2: rule__Game__Group__7__Impl rule__Game__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__7"


    // $ANTLR start "rule__Game__Group__7__Impl"
    // InternalGames.g:683:1: rule__Game__Group__7__Impl : ( ( rule__Game__Group_7__0 )* ) ;
    public final void rule__Game__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:687:1: ( ( ( rule__Game__Group_7__0 )* ) )
            // InternalGames.g:688:1: ( ( rule__Game__Group_7__0 )* )
            {
            // InternalGames.g:688:1: ( ( rule__Game__Group_7__0 )* )
            // InternalGames.g:689:2: ( rule__Game__Group_7__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_7()); 
            // InternalGames.g:690:2: ( rule__Game__Group_7__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==25) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGames.g:690:3: rule__Game__Group_7__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__7__Impl"


    // $ANTLR start "rule__Game__Group__8"
    // InternalGames.g:698:1: rule__Game__Group__8 : rule__Game__Group__8__Impl rule__Game__Group__9 ;
    public final void rule__Game__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:702:1: ( rule__Game__Group__8__Impl rule__Game__Group__9 )
            // InternalGames.g:703:2: rule__Game__Group__8__Impl rule__Game__Group__9
            {
            pushFollow(FOLLOW_11);
            rule__Game__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__8"


    // $ANTLR start "rule__Game__Group__8__Impl"
    // InternalGames.g:710:1: rule__Game__Group__8__Impl : ( ']' ) ;
    public final void rule__Game__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:714:1: ( ( ']' ) )
            // InternalGames.g:715:1: ( ']' )
            {
            // InternalGames.g:715:1: ( ']' )
            // InternalGames.g:716:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_8()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__8__Impl"


    // $ANTLR start "rule__Game__Group__9"
    // InternalGames.g:725:1: rule__Game__Group__9 : rule__Game__Group__9__Impl rule__Game__Group__10 ;
    public final void rule__Game__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:729:1: ( rule__Game__Group__9__Impl rule__Game__Group__10 )
            // InternalGames.g:730:2: rule__Game__Group__9__Impl rule__Game__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Game__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__9"


    // $ANTLR start "rule__Game__Group__9__Impl"
    // InternalGames.g:737:1: rule__Game__Group__9__Impl : ( ( rule__Game__Group_9__0 )? ) ;
    public final void rule__Game__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:741:1: ( ( ( rule__Game__Group_9__0 )? ) )
            // InternalGames.g:742:1: ( ( rule__Game__Group_9__0 )? )
            {
            // InternalGames.g:742:1: ( ( rule__Game__Group_9__0 )? )
            // InternalGames.g:743:2: ( rule__Game__Group_9__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_9()); 
            // InternalGames.g:744:2: ( rule__Game__Group_9__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalGames.g:744:3: rule__Game__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__9__Impl"


    // $ANTLR start "rule__Game__Group__10"
    // InternalGames.g:752:1: rule__Game__Group__10 : rule__Game__Group__10__Impl rule__Game__Group__11 ;
    public final void rule__Game__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:756:1: ( rule__Game__Group__10__Impl rule__Game__Group__11 )
            // InternalGames.g:757:2: rule__Game__Group__10__Impl rule__Game__Group__11
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__10"


    // $ANTLR start "rule__Game__Group__10__Impl"
    // InternalGames.g:764:1: rule__Game__Group__10__Impl : ( 'people' ) ;
    public final void rule__Game__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:768:1: ( ( 'people' ) )
            // InternalGames.g:769:1: ( 'people' )
            {
            // InternalGames.g:769:1: ( 'people' )
            // InternalGames.g:770:2: 'people'
            {
             before(grammarAccess.getGameAccess().getPeopleKeyword_10()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getPeopleKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__10__Impl"


    // $ANTLR start "rule__Game__Group__11"
    // InternalGames.g:779:1: rule__Game__Group__11 : rule__Game__Group__11__Impl rule__Game__Group__12 ;
    public final void rule__Game__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:783:1: ( rule__Game__Group__11__Impl rule__Game__Group__12 )
            // InternalGames.g:784:2: rule__Game__Group__11__Impl rule__Game__Group__12
            {
            pushFollow(FOLLOW_12);
            rule__Game__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__11"


    // $ANTLR start "rule__Game__Group__11__Impl"
    // InternalGames.g:791:1: rule__Game__Group__11__Impl : ( '[' ) ;
    public final void rule__Game__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:795:1: ( ( '[' ) )
            // InternalGames.g:796:1: ( '[' )
            {
            // InternalGames.g:796:1: ( '[' )
            // InternalGames.g:797:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_11()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__11__Impl"


    // $ANTLR start "rule__Game__Group__12"
    // InternalGames.g:806:1: rule__Game__Group__12 : rule__Game__Group__12__Impl rule__Game__Group__13 ;
    public final void rule__Game__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:810:1: ( rule__Game__Group__12__Impl rule__Game__Group__13 )
            // InternalGames.g:811:2: rule__Game__Group__12__Impl rule__Game__Group__13
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__12"


    // $ANTLR start "rule__Game__Group__12__Impl"
    // InternalGames.g:818:1: rule__Game__Group__12__Impl : ( ( rule__Game__PeopleAssignment_12 ) ) ;
    public final void rule__Game__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:822:1: ( ( ( rule__Game__PeopleAssignment_12 ) ) )
            // InternalGames.g:823:1: ( ( rule__Game__PeopleAssignment_12 ) )
            {
            // InternalGames.g:823:1: ( ( rule__Game__PeopleAssignment_12 ) )
            // InternalGames.g:824:2: ( rule__Game__PeopleAssignment_12 )
            {
             before(grammarAccess.getGameAccess().getPeopleAssignment_12()); 
            // InternalGames.g:825:2: ( rule__Game__PeopleAssignment_12 )
            // InternalGames.g:825:3: rule__Game__PeopleAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Game__PeopleAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPeopleAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__12__Impl"


    // $ANTLR start "rule__Game__Group__13"
    // InternalGames.g:833:1: rule__Game__Group__13 : rule__Game__Group__13__Impl rule__Game__Group__14 ;
    public final void rule__Game__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:837:1: ( rule__Game__Group__13__Impl rule__Game__Group__14 )
            // InternalGames.g:838:2: rule__Game__Group__13__Impl rule__Game__Group__14
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__13"


    // $ANTLR start "rule__Game__Group__13__Impl"
    // InternalGames.g:845:1: rule__Game__Group__13__Impl : ( ( rule__Game__Group_13__0 )* ) ;
    public final void rule__Game__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:849:1: ( ( ( rule__Game__Group_13__0 )* ) )
            // InternalGames.g:850:1: ( ( rule__Game__Group_13__0 )* )
            {
            // InternalGames.g:850:1: ( ( rule__Game__Group_13__0 )* )
            // InternalGames.g:851:2: ( rule__Game__Group_13__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_13()); 
            // InternalGames.g:852:2: ( rule__Game__Group_13__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==25) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGames.g:852:3: rule__Game__Group_13__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__13__Impl"


    // $ANTLR start "rule__Game__Group__14"
    // InternalGames.g:860:1: rule__Game__Group__14 : rule__Game__Group__14__Impl rule__Game__Group__15 ;
    public final void rule__Game__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:864:1: ( rule__Game__Group__14__Impl rule__Game__Group__15 )
            // InternalGames.g:865:2: rule__Game__Group__14__Impl rule__Game__Group__15
            {
            pushFollow(FOLLOW_13);
            rule__Game__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__14"


    // $ANTLR start "rule__Game__Group__14__Impl"
    // InternalGames.g:872:1: rule__Game__Group__14__Impl : ( ']' ) ;
    public final void rule__Game__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:876:1: ( ( ']' ) )
            // InternalGames.g:877:1: ( ']' )
            {
            // InternalGames.g:877:1: ( ']' )
            // InternalGames.g:878:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_14()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__14__Impl"


    // $ANTLR start "rule__Game__Group__15"
    // InternalGames.g:887:1: rule__Game__Group__15 : rule__Game__Group__15__Impl rule__Game__Group__16 ;
    public final void rule__Game__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:891:1: ( rule__Game__Group__15__Impl rule__Game__Group__16 )
            // InternalGames.g:892:2: rule__Game__Group__15__Impl rule__Game__Group__16
            {
            pushFollow(FOLLOW_13);
            rule__Game__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__15"


    // $ANTLR start "rule__Game__Group__15__Impl"
    // InternalGames.g:899:1: rule__Game__Group__15__Impl : ( ( rule__Game__Group_15__0 )? ) ;
    public final void rule__Game__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:903:1: ( ( ( rule__Game__Group_15__0 )? ) )
            // InternalGames.g:904:1: ( ( rule__Game__Group_15__0 )? )
            {
            // InternalGames.g:904:1: ( ( rule__Game__Group_15__0 )? )
            // InternalGames.g:905:2: ( rule__Game__Group_15__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_15()); 
            // InternalGames.g:906:2: ( rule__Game__Group_15__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGames.g:906:3: rule__Game__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__15__Impl"


    // $ANTLR start "rule__Game__Group__16"
    // InternalGames.g:914:1: rule__Game__Group__16 : rule__Game__Group__16__Impl rule__Game__Group__17 ;
    public final void rule__Game__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:918:1: ( rule__Game__Group__16__Impl rule__Game__Group__17 )
            // InternalGames.g:919:2: rule__Game__Group__16__Impl rule__Game__Group__17
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__16"


    // $ANTLR start "rule__Game__Group__16__Impl"
    // InternalGames.g:926:1: rule__Game__Group__16__Impl : ( 'path' ) ;
    public final void rule__Game__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:930:1: ( ( 'path' ) )
            // InternalGames.g:931:1: ( 'path' )
            {
            // InternalGames.g:931:1: ( 'path' )
            // InternalGames.g:932:2: 'path'
            {
             before(grammarAccess.getGameAccess().getPathKeyword_16()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getPathKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__16__Impl"


    // $ANTLR start "rule__Game__Group__17"
    // InternalGames.g:941:1: rule__Game__Group__17 : rule__Game__Group__17__Impl rule__Game__Group__18 ;
    public final void rule__Game__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:945:1: ( rule__Game__Group__17__Impl rule__Game__Group__18 )
            // InternalGames.g:946:2: rule__Game__Group__17__Impl rule__Game__Group__18
            {
            pushFollow(FOLLOW_14);
            rule__Game__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__17"


    // $ANTLR start "rule__Game__Group__17__Impl"
    // InternalGames.g:953:1: rule__Game__Group__17__Impl : ( '[' ) ;
    public final void rule__Game__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:957:1: ( ( '[' ) )
            // InternalGames.g:958:1: ( '[' )
            {
            // InternalGames.g:958:1: ( '[' )
            // InternalGames.g:959:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_17()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__17__Impl"


    // $ANTLR start "rule__Game__Group__18"
    // InternalGames.g:968:1: rule__Game__Group__18 : rule__Game__Group__18__Impl rule__Game__Group__19 ;
    public final void rule__Game__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:972:1: ( rule__Game__Group__18__Impl rule__Game__Group__19 )
            // InternalGames.g:973:2: rule__Game__Group__18__Impl rule__Game__Group__19
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__18"


    // $ANTLR start "rule__Game__Group__18__Impl"
    // InternalGames.g:980:1: rule__Game__Group__18__Impl : ( ( rule__Game__PathAssignment_18 ) ) ;
    public final void rule__Game__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:984:1: ( ( ( rule__Game__PathAssignment_18 ) ) )
            // InternalGames.g:985:1: ( ( rule__Game__PathAssignment_18 ) )
            {
            // InternalGames.g:985:1: ( ( rule__Game__PathAssignment_18 ) )
            // InternalGames.g:986:2: ( rule__Game__PathAssignment_18 )
            {
             before(grammarAccess.getGameAccess().getPathAssignment_18()); 
            // InternalGames.g:987:2: ( rule__Game__PathAssignment_18 )
            // InternalGames.g:987:3: rule__Game__PathAssignment_18
            {
            pushFollow(FOLLOW_2);
            rule__Game__PathAssignment_18();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPathAssignment_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__18__Impl"


    // $ANTLR start "rule__Game__Group__19"
    // InternalGames.g:995:1: rule__Game__Group__19 : rule__Game__Group__19__Impl rule__Game__Group__20 ;
    public final void rule__Game__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:999:1: ( rule__Game__Group__19__Impl rule__Game__Group__20 )
            // InternalGames.g:1000:2: rule__Game__Group__19__Impl rule__Game__Group__20
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__19"


    // $ANTLR start "rule__Game__Group__19__Impl"
    // InternalGames.g:1007:1: rule__Game__Group__19__Impl : ( ( rule__Game__Group_19__0 )* ) ;
    public final void rule__Game__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1011:1: ( ( ( rule__Game__Group_19__0 )* ) )
            // InternalGames.g:1012:1: ( ( rule__Game__Group_19__0 )* )
            {
            // InternalGames.g:1012:1: ( ( rule__Game__Group_19__0 )* )
            // InternalGames.g:1013:2: ( rule__Game__Group_19__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_19()); 
            // InternalGames.g:1014:2: ( rule__Game__Group_19__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGames.g:1014:3: rule__Game__Group_19__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_19__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__19__Impl"


    // $ANTLR start "rule__Game__Group__20"
    // InternalGames.g:1022:1: rule__Game__Group__20 : rule__Game__Group__20__Impl rule__Game__Group__21 ;
    public final void rule__Game__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1026:1: ( rule__Game__Group__20__Impl rule__Game__Group__21 )
            // InternalGames.g:1027:2: rule__Game__Group__20__Impl rule__Game__Group__21
            {
            pushFollow(FOLLOW_15);
            rule__Game__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__20"


    // $ANTLR start "rule__Game__Group__20__Impl"
    // InternalGames.g:1034:1: rule__Game__Group__20__Impl : ( ']' ) ;
    public final void rule__Game__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1038:1: ( ( ']' ) )
            // InternalGames.g:1039:1: ( ']' )
            {
            // InternalGames.g:1039:1: ( ']' )
            // InternalGames.g:1040:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_20()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__20__Impl"


    // $ANTLR start "rule__Game__Group__21"
    // InternalGames.g:1049:1: rule__Game__Group__21 : rule__Game__Group__21__Impl rule__Game__Group__22 ;
    public final void rule__Game__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1053:1: ( rule__Game__Group__21__Impl rule__Game__Group__22 )
            // InternalGames.g:1054:2: rule__Game__Group__21__Impl rule__Game__Group__22
            {
            pushFollow(FOLLOW_15);
            rule__Game__Group__21__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__22();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__21"


    // $ANTLR start "rule__Game__Group__21__Impl"
    // InternalGames.g:1061:1: rule__Game__Group__21__Impl : ( ( rule__Game__Group_21__0 )? ) ;
    public final void rule__Game__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1065:1: ( ( ( rule__Game__Group_21__0 )? ) )
            // InternalGames.g:1066:1: ( ( rule__Game__Group_21__0 )? )
            {
            // InternalGames.g:1066:1: ( ( rule__Game__Group_21__0 )? )
            // InternalGames.g:1067:2: ( rule__Game__Group_21__0 )?
            {
             before(grammarAccess.getGameAccess().getGroup_21()); 
            // InternalGames.g:1068:2: ( rule__Game__Group_21__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalGames.g:1068:3: rule__Game__Group_21__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Game__Group_21__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGameAccess().getGroup_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__21__Impl"


    // $ANTLR start "rule__Game__Group__22"
    // InternalGames.g:1076:1: rule__Game__Group__22 : rule__Game__Group__22__Impl rule__Game__Group__23 ;
    public final void rule__Game__Group__22() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1080:1: ( rule__Game__Group__22__Impl rule__Game__Group__23 )
            // InternalGames.g:1081:2: rule__Game__Group__22__Impl rule__Game__Group__23
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__22__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__23();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__22"


    // $ANTLR start "rule__Game__Group__22__Impl"
    // InternalGames.g:1088:1: rule__Game__Group__22__Impl : ( 'startPlace' ) ;
    public final void rule__Game__Group__22__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1092:1: ( ( 'startPlace' ) )
            // InternalGames.g:1093:1: ( 'startPlace' )
            {
            // InternalGames.g:1093:1: ( 'startPlace' )
            // InternalGames.g:1094:2: 'startPlace'
            {
             before(grammarAccess.getGameAccess().getStartPlaceKeyword_22()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getStartPlaceKeyword_22()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__22__Impl"


    // $ANTLR start "rule__Game__Group__23"
    // InternalGames.g:1103:1: rule__Game__Group__23 : rule__Game__Group__23__Impl rule__Game__Group__24 ;
    public final void rule__Game__Group__23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1107:1: ( rule__Game__Group__23__Impl rule__Game__Group__24 )
            // InternalGames.g:1108:2: rule__Game__Group__23__Impl rule__Game__Group__24
            {
            pushFollow(FOLLOW_16);
            rule__Game__Group__23__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__24();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__23"


    // $ANTLR start "rule__Game__Group__23__Impl"
    // InternalGames.g:1115:1: rule__Game__Group__23__Impl : ( ( rule__Game__StartPlaceAssignment_23 ) ) ;
    public final void rule__Game__Group__23__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1119:1: ( ( ( rule__Game__StartPlaceAssignment_23 ) ) )
            // InternalGames.g:1120:1: ( ( rule__Game__StartPlaceAssignment_23 ) )
            {
            // InternalGames.g:1120:1: ( ( rule__Game__StartPlaceAssignment_23 ) )
            // InternalGames.g:1121:2: ( rule__Game__StartPlaceAssignment_23 )
            {
             before(grammarAccess.getGameAccess().getStartPlaceAssignment_23()); 
            // InternalGames.g:1122:2: ( rule__Game__StartPlaceAssignment_23 )
            // InternalGames.g:1122:3: rule__Game__StartPlaceAssignment_23
            {
            pushFollow(FOLLOW_2);
            rule__Game__StartPlaceAssignment_23();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getStartPlaceAssignment_23()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__23__Impl"


    // $ANTLR start "rule__Game__Group__24"
    // InternalGames.g:1130:1: rule__Game__Group__24 : rule__Game__Group__24__Impl rule__Game__Group__25 ;
    public final void rule__Game__Group__24() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1134:1: ( rule__Game__Group__24__Impl rule__Game__Group__25 )
            // InternalGames.g:1135:2: rule__Game__Group__24__Impl rule__Game__Group__25
            {
            pushFollow(FOLLOW_3);
            rule__Game__Group__24__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__25();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__24"


    // $ANTLR start "rule__Game__Group__24__Impl"
    // InternalGames.g:1142:1: rule__Game__Group__24__Impl : ( 'endPlace' ) ;
    public final void rule__Game__Group__24__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1146:1: ( ( 'endPlace' ) )
            // InternalGames.g:1147:1: ( 'endPlace' )
            {
            // InternalGames.g:1147:1: ( 'endPlace' )
            // InternalGames.g:1148:2: 'endPlace'
            {
             before(grammarAccess.getGameAccess().getEndPlaceKeyword_24()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getEndPlaceKeyword_24()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__24__Impl"


    // $ANTLR start "rule__Game__Group__25"
    // InternalGames.g:1157:1: rule__Game__Group__25 : rule__Game__Group__25__Impl rule__Game__Group__26 ;
    public final void rule__Game__Group__25() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1161:1: ( rule__Game__Group__25__Impl rule__Game__Group__26 )
            // InternalGames.g:1162:2: rule__Game__Group__25__Impl rule__Game__Group__26
            {
            pushFollow(FOLLOW_17);
            rule__Game__Group__25__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group__26();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__25"


    // $ANTLR start "rule__Game__Group__25__Impl"
    // InternalGames.g:1169:1: rule__Game__Group__25__Impl : ( ( ( rule__Game__EndPlaceAssignment_25 ) ) ( ( rule__Game__EndPlaceAssignment_25 )* ) ) ;
    public final void rule__Game__Group__25__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1173:1: ( ( ( ( rule__Game__EndPlaceAssignment_25 ) ) ( ( rule__Game__EndPlaceAssignment_25 )* ) ) )
            // InternalGames.g:1174:1: ( ( ( rule__Game__EndPlaceAssignment_25 ) ) ( ( rule__Game__EndPlaceAssignment_25 )* ) )
            {
            // InternalGames.g:1174:1: ( ( ( rule__Game__EndPlaceAssignment_25 ) ) ( ( rule__Game__EndPlaceAssignment_25 )* ) )
            // InternalGames.g:1175:2: ( ( rule__Game__EndPlaceAssignment_25 ) ) ( ( rule__Game__EndPlaceAssignment_25 )* )
            {
            // InternalGames.g:1175:2: ( ( rule__Game__EndPlaceAssignment_25 ) )
            // InternalGames.g:1176:3: ( rule__Game__EndPlaceAssignment_25 )
            {
             before(grammarAccess.getGameAccess().getEndPlaceAssignment_25()); 
            // InternalGames.g:1177:3: ( rule__Game__EndPlaceAssignment_25 )
            // InternalGames.g:1177:4: rule__Game__EndPlaceAssignment_25
            {
            pushFollow(FOLLOW_18);
            rule__Game__EndPlaceAssignment_25();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getEndPlaceAssignment_25()); 

            }

            // InternalGames.g:1180:2: ( ( rule__Game__EndPlaceAssignment_25 )* )
            // InternalGames.g:1181:3: ( rule__Game__EndPlaceAssignment_25 )*
            {
             before(grammarAccess.getGameAccess().getEndPlaceAssignment_25()); 
            // InternalGames.g:1182:3: ( rule__Game__EndPlaceAssignment_25 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGames.g:1182:4: rule__Game__EndPlaceAssignment_25
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Game__EndPlaceAssignment_25();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getEndPlaceAssignment_25()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__25__Impl"


    // $ANTLR start "rule__Game__Group__26"
    // InternalGames.g:1191:1: rule__Game__Group__26 : rule__Game__Group__26__Impl ;
    public final void rule__Game__Group__26() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1195:1: ( rule__Game__Group__26__Impl )
            // InternalGames.g:1196:2: rule__Game__Group__26__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group__26__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__26"


    // $ANTLR start "rule__Game__Group__26__Impl"
    // InternalGames.g:1202:1: rule__Game__Group__26__Impl : ( ( rule__Game__DifficultyAssignment_26 ) ) ;
    public final void rule__Game__Group__26__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1206:1: ( ( ( rule__Game__DifficultyAssignment_26 ) ) )
            // InternalGames.g:1207:1: ( ( rule__Game__DifficultyAssignment_26 ) )
            {
            // InternalGames.g:1207:1: ( ( rule__Game__DifficultyAssignment_26 ) )
            // InternalGames.g:1208:2: ( rule__Game__DifficultyAssignment_26 )
            {
             before(grammarAccess.getGameAccess().getDifficultyAssignment_26()); 
            // InternalGames.g:1209:2: ( rule__Game__DifficultyAssignment_26 )
            // InternalGames.g:1209:3: rule__Game__DifficultyAssignment_26
            {
            pushFollow(FOLLOW_2);
            rule__Game__DifficultyAssignment_26();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getDifficultyAssignment_26()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group__26__Impl"


    // $ANTLR start "rule__Game__Group_7__0"
    // InternalGames.g:1218:1: rule__Game__Group_7__0 : rule__Game__Group_7__0__Impl rule__Game__Group_7__1 ;
    public final void rule__Game__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1222:1: ( rule__Game__Group_7__0__Impl rule__Game__Group_7__1 )
            // InternalGames.g:1223:2: rule__Game__Group_7__0__Impl rule__Game__Group_7__1
            {
            pushFollow(FOLLOW_8);
            rule__Game__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_7__0"


    // $ANTLR start "rule__Game__Group_7__0__Impl"
    // InternalGames.g:1230:1: rule__Game__Group_7__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1234:1: ( ( ',' ) )
            // InternalGames.g:1235:1: ( ',' )
            {
            // InternalGames.g:1235:1: ( ',' )
            // InternalGames.g:1236:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_7_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_7__0__Impl"


    // $ANTLR start "rule__Game__Group_7__1"
    // InternalGames.g:1245:1: rule__Game__Group_7__1 : rule__Game__Group_7__1__Impl ;
    public final void rule__Game__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1249:1: ( rule__Game__Group_7__1__Impl )
            // InternalGames.g:1250:2: rule__Game__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_7__1"


    // $ANTLR start "rule__Game__Group_7__1__Impl"
    // InternalGames.g:1256:1: rule__Game__Group_7__1__Impl : ( ( rule__Game__PlacesAssignment_7_1 ) ) ;
    public final void rule__Game__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1260:1: ( ( ( rule__Game__PlacesAssignment_7_1 ) ) )
            // InternalGames.g:1261:1: ( ( rule__Game__PlacesAssignment_7_1 ) )
            {
            // InternalGames.g:1261:1: ( ( rule__Game__PlacesAssignment_7_1 ) )
            // InternalGames.g:1262:2: ( rule__Game__PlacesAssignment_7_1 )
            {
             before(grammarAccess.getGameAccess().getPlacesAssignment_7_1()); 
            // InternalGames.g:1263:2: ( rule__Game__PlacesAssignment_7_1 )
            // InternalGames.g:1263:3: rule__Game__PlacesAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__PlacesAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPlacesAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_7__1__Impl"


    // $ANTLR start "rule__Game__Group_9__0"
    // InternalGames.g:1272:1: rule__Game__Group_9__0 : rule__Game__Group_9__0__Impl rule__Game__Group_9__1 ;
    public final void rule__Game__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1276:1: ( rule__Game__Group_9__0__Impl rule__Game__Group_9__1 )
            // InternalGames.g:1277:2: rule__Game__Group_9__0__Impl rule__Game__Group_9__1
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__0"


    // $ANTLR start "rule__Game__Group_9__0__Impl"
    // InternalGames.g:1284:1: rule__Game__Group_9__0__Impl : ( 'knowledge' ) ;
    public final void rule__Game__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1288:1: ( ( 'knowledge' ) )
            // InternalGames.g:1289:1: ( 'knowledge' )
            {
            // InternalGames.g:1289:1: ( 'knowledge' )
            // InternalGames.g:1290:2: 'knowledge'
            {
             before(grammarAccess.getGameAccess().getKnowledgeKeyword_9_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getKnowledgeKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__0__Impl"


    // $ANTLR start "rule__Game__Group_9__1"
    // InternalGames.g:1299:1: rule__Game__Group_9__1 : rule__Game__Group_9__1__Impl rule__Game__Group_9__2 ;
    public final void rule__Game__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1303:1: ( rule__Game__Group_9__1__Impl rule__Game__Group_9__2 )
            // InternalGames.g:1304:2: rule__Game__Group_9__1__Impl rule__Game__Group_9__2
            {
            pushFollow(FOLLOW_19);
            rule__Game__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__1"


    // $ANTLR start "rule__Game__Group_9__1__Impl"
    // InternalGames.g:1311:1: rule__Game__Group_9__1__Impl : ( '[' ) ;
    public final void rule__Game__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1315:1: ( ( '[' ) )
            // InternalGames.g:1316:1: ( '[' )
            {
            // InternalGames.g:1316:1: ( '[' )
            // InternalGames.g:1317:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_9_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__1__Impl"


    // $ANTLR start "rule__Game__Group_9__2"
    // InternalGames.g:1326:1: rule__Game__Group_9__2 : rule__Game__Group_9__2__Impl rule__Game__Group_9__3 ;
    public final void rule__Game__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1330:1: ( rule__Game__Group_9__2__Impl rule__Game__Group_9__3 )
            // InternalGames.g:1331:2: rule__Game__Group_9__2__Impl rule__Game__Group_9__3
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__2"


    // $ANTLR start "rule__Game__Group_9__2__Impl"
    // InternalGames.g:1338:1: rule__Game__Group_9__2__Impl : ( ( rule__Game__KnowledgeAssignment_9_2 ) ) ;
    public final void rule__Game__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1342:1: ( ( ( rule__Game__KnowledgeAssignment_9_2 ) ) )
            // InternalGames.g:1343:1: ( ( rule__Game__KnowledgeAssignment_9_2 ) )
            {
            // InternalGames.g:1343:1: ( ( rule__Game__KnowledgeAssignment_9_2 ) )
            // InternalGames.g:1344:2: ( rule__Game__KnowledgeAssignment_9_2 )
            {
             before(grammarAccess.getGameAccess().getKnowledgeAssignment_9_2()); 
            // InternalGames.g:1345:2: ( rule__Game__KnowledgeAssignment_9_2 )
            // InternalGames.g:1345:3: rule__Game__KnowledgeAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__KnowledgeAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getKnowledgeAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__2__Impl"


    // $ANTLR start "rule__Game__Group_9__3"
    // InternalGames.g:1353:1: rule__Game__Group_9__3 : rule__Game__Group_9__3__Impl rule__Game__Group_9__4 ;
    public final void rule__Game__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1357:1: ( rule__Game__Group_9__3__Impl rule__Game__Group_9__4 )
            // InternalGames.g:1358:2: rule__Game__Group_9__3__Impl rule__Game__Group_9__4
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_9__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_9__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__3"


    // $ANTLR start "rule__Game__Group_9__3__Impl"
    // InternalGames.g:1365:1: rule__Game__Group_9__3__Impl : ( ( rule__Game__Group_9_3__0 )* ) ;
    public final void rule__Game__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1369:1: ( ( ( rule__Game__Group_9_3__0 )* ) )
            // InternalGames.g:1370:1: ( ( rule__Game__Group_9_3__0 )* )
            {
            // InternalGames.g:1370:1: ( ( rule__Game__Group_9_3__0 )* )
            // InternalGames.g:1371:2: ( rule__Game__Group_9_3__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_9_3()); 
            // InternalGames.g:1372:2: ( rule__Game__Group_9_3__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalGames.g:1372:3: rule__Game__Group_9_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_9_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__3__Impl"


    // $ANTLR start "rule__Game__Group_9__4"
    // InternalGames.g:1380:1: rule__Game__Group_9__4 : rule__Game__Group_9__4__Impl ;
    public final void rule__Game__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1384:1: ( rule__Game__Group_9__4__Impl )
            // InternalGames.g:1385:2: rule__Game__Group_9__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_9__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__4"


    // $ANTLR start "rule__Game__Group_9__4__Impl"
    // InternalGames.g:1391:1: rule__Game__Group_9__4__Impl : ( ']' ) ;
    public final void rule__Game__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1395:1: ( ( ']' ) )
            // InternalGames.g:1396:1: ( ']' )
            {
            // InternalGames.g:1396:1: ( ']' )
            // InternalGames.g:1397:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_9_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_9_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9__4__Impl"


    // $ANTLR start "rule__Game__Group_9_3__0"
    // InternalGames.g:1407:1: rule__Game__Group_9_3__0 : rule__Game__Group_9_3__0__Impl rule__Game__Group_9_3__1 ;
    public final void rule__Game__Group_9_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1411:1: ( rule__Game__Group_9_3__0__Impl rule__Game__Group_9_3__1 )
            // InternalGames.g:1412:2: rule__Game__Group_9_3__0__Impl rule__Game__Group_9_3__1
            {
            pushFollow(FOLLOW_19);
            rule__Game__Group_9_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_9_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9_3__0"


    // $ANTLR start "rule__Game__Group_9_3__0__Impl"
    // InternalGames.g:1419:1: rule__Game__Group_9_3__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_9_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1423:1: ( ( ',' ) )
            // InternalGames.g:1424:1: ( ',' )
            {
            // InternalGames.g:1424:1: ( ',' )
            // InternalGames.g:1425:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_9_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9_3__0__Impl"


    // $ANTLR start "rule__Game__Group_9_3__1"
    // InternalGames.g:1434:1: rule__Game__Group_9_3__1 : rule__Game__Group_9_3__1__Impl ;
    public final void rule__Game__Group_9_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1438:1: ( rule__Game__Group_9_3__1__Impl )
            // InternalGames.g:1439:2: rule__Game__Group_9_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_9_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9_3__1"


    // $ANTLR start "rule__Game__Group_9_3__1__Impl"
    // InternalGames.g:1445:1: rule__Game__Group_9_3__1__Impl : ( ( rule__Game__KnowledgeAssignment_9_3_1 ) ) ;
    public final void rule__Game__Group_9_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1449:1: ( ( ( rule__Game__KnowledgeAssignment_9_3_1 ) ) )
            // InternalGames.g:1450:1: ( ( rule__Game__KnowledgeAssignment_9_3_1 ) )
            {
            // InternalGames.g:1450:1: ( ( rule__Game__KnowledgeAssignment_9_3_1 ) )
            // InternalGames.g:1451:2: ( rule__Game__KnowledgeAssignment_9_3_1 )
            {
             before(grammarAccess.getGameAccess().getKnowledgeAssignment_9_3_1()); 
            // InternalGames.g:1452:2: ( rule__Game__KnowledgeAssignment_9_3_1 )
            // InternalGames.g:1452:3: rule__Game__KnowledgeAssignment_9_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__KnowledgeAssignment_9_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getKnowledgeAssignment_9_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_9_3__1__Impl"


    // $ANTLR start "rule__Game__Group_13__0"
    // InternalGames.g:1461:1: rule__Game__Group_13__0 : rule__Game__Group_13__0__Impl rule__Game__Group_13__1 ;
    public final void rule__Game__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1465:1: ( rule__Game__Group_13__0__Impl rule__Game__Group_13__1 )
            // InternalGames.g:1466:2: rule__Game__Group_13__0__Impl rule__Game__Group_13__1
            {
            pushFollow(FOLLOW_12);
            rule__Game__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_13__0"


    // $ANTLR start "rule__Game__Group_13__0__Impl"
    // InternalGames.g:1473:1: rule__Game__Group_13__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1477:1: ( ( ',' ) )
            // InternalGames.g:1478:1: ( ',' )
            {
            // InternalGames.g:1478:1: ( ',' )
            // InternalGames.g:1479:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_13_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_13__0__Impl"


    // $ANTLR start "rule__Game__Group_13__1"
    // InternalGames.g:1488:1: rule__Game__Group_13__1 : rule__Game__Group_13__1__Impl ;
    public final void rule__Game__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1492:1: ( rule__Game__Group_13__1__Impl )
            // InternalGames.g:1493:2: rule__Game__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_13__1"


    // $ANTLR start "rule__Game__Group_13__1__Impl"
    // InternalGames.g:1499:1: rule__Game__Group_13__1__Impl : ( ( rule__Game__PeopleAssignment_13_1 ) ) ;
    public final void rule__Game__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1503:1: ( ( ( rule__Game__PeopleAssignment_13_1 ) ) )
            // InternalGames.g:1504:1: ( ( rule__Game__PeopleAssignment_13_1 ) )
            {
            // InternalGames.g:1504:1: ( ( rule__Game__PeopleAssignment_13_1 ) )
            // InternalGames.g:1505:2: ( rule__Game__PeopleAssignment_13_1 )
            {
             before(grammarAccess.getGameAccess().getPeopleAssignment_13_1()); 
            // InternalGames.g:1506:2: ( rule__Game__PeopleAssignment_13_1 )
            // InternalGames.g:1506:3: rule__Game__PeopleAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__PeopleAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPeopleAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_13__1__Impl"


    // $ANTLR start "rule__Game__Group_15__0"
    // InternalGames.g:1515:1: rule__Game__Group_15__0 : rule__Game__Group_15__0__Impl rule__Game__Group_15__1 ;
    public final void rule__Game__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1519:1: ( rule__Game__Group_15__0__Impl rule__Game__Group_15__1 )
            // InternalGames.g:1520:2: rule__Game__Group_15__0__Impl rule__Game__Group_15__1
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__0"


    // $ANTLR start "rule__Game__Group_15__0__Impl"
    // InternalGames.g:1527:1: rule__Game__Group_15__0__Impl : ( 'items' ) ;
    public final void rule__Game__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1531:1: ( ( 'items' ) )
            // InternalGames.g:1532:1: ( 'items' )
            {
            // InternalGames.g:1532:1: ( 'items' )
            // InternalGames.g:1533:2: 'items'
            {
             before(grammarAccess.getGameAccess().getItemsKeyword_15_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getItemsKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__0__Impl"


    // $ANTLR start "rule__Game__Group_15__1"
    // InternalGames.g:1542:1: rule__Game__Group_15__1 : rule__Game__Group_15__1__Impl rule__Game__Group_15__2 ;
    public final void rule__Game__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1546:1: ( rule__Game__Group_15__1__Impl rule__Game__Group_15__2 )
            // InternalGames.g:1547:2: rule__Game__Group_15__1__Impl rule__Game__Group_15__2
            {
            pushFollow(FOLLOW_20);
            rule__Game__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__1"


    // $ANTLR start "rule__Game__Group_15__1__Impl"
    // InternalGames.g:1554:1: rule__Game__Group_15__1__Impl : ( '[' ) ;
    public final void rule__Game__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1558:1: ( ( '[' ) )
            // InternalGames.g:1559:1: ( '[' )
            {
            // InternalGames.g:1559:1: ( '[' )
            // InternalGames.g:1560:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_15_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__1__Impl"


    // $ANTLR start "rule__Game__Group_15__2"
    // InternalGames.g:1569:1: rule__Game__Group_15__2 : rule__Game__Group_15__2__Impl rule__Game__Group_15__3 ;
    public final void rule__Game__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1573:1: ( rule__Game__Group_15__2__Impl rule__Game__Group_15__3 )
            // InternalGames.g:1574:2: rule__Game__Group_15__2__Impl rule__Game__Group_15__3
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_15__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__2"


    // $ANTLR start "rule__Game__Group_15__2__Impl"
    // InternalGames.g:1581:1: rule__Game__Group_15__2__Impl : ( ( rule__Game__ItemsAssignment_15_2 ) ) ;
    public final void rule__Game__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1585:1: ( ( ( rule__Game__ItemsAssignment_15_2 ) ) )
            // InternalGames.g:1586:1: ( ( rule__Game__ItemsAssignment_15_2 ) )
            {
            // InternalGames.g:1586:1: ( ( rule__Game__ItemsAssignment_15_2 ) )
            // InternalGames.g:1587:2: ( rule__Game__ItemsAssignment_15_2 )
            {
             before(grammarAccess.getGameAccess().getItemsAssignment_15_2()); 
            // InternalGames.g:1588:2: ( rule__Game__ItemsAssignment_15_2 )
            // InternalGames.g:1588:3: rule__Game__ItemsAssignment_15_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__ItemsAssignment_15_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getItemsAssignment_15_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__2__Impl"


    // $ANTLR start "rule__Game__Group_15__3"
    // InternalGames.g:1596:1: rule__Game__Group_15__3 : rule__Game__Group_15__3__Impl rule__Game__Group_15__4 ;
    public final void rule__Game__Group_15__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1600:1: ( rule__Game__Group_15__3__Impl rule__Game__Group_15__4 )
            // InternalGames.g:1601:2: rule__Game__Group_15__3__Impl rule__Game__Group_15__4
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_15__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__3"


    // $ANTLR start "rule__Game__Group_15__3__Impl"
    // InternalGames.g:1608:1: rule__Game__Group_15__3__Impl : ( ( rule__Game__Group_15_3__0 )* ) ;
    public final void rule__Game__Group_15__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1612:1: ( ( ( rule__Game__Group_15_3__0 )* ) )
            // InternalGames.g:1613:1: ( ( rule__Game__Group_15_3__0 )* )
            {
            // InternalGames.g:1613:1: ( ( rule__Game__Group_15_3__0 )* )
            // InternalGames.g:1614:2: ( rule__Game__Group_15_3__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_15_3()); 
            // InternalGames.g:1615:2: ( rule__Game__Group_15_3__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalGames.g:1615:3: rule__Game__Group_15_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_15_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_15_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__3__Impl"


    // $ANTLR start "rule__Game__Group_15__4"
    // InternalGames.g:1623:1: rule__Game__Group_15__4 : rule__Game__Group_15__4__Impl ;
    public final void rule__Game__Group_15__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1627:1: ( rule__Game__Group_15__4__Impl )
            // InternalGames.g:1628:2: rule__Game__Group_15__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_15__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__4"


    // $ANTLR start "rule__Game__Group_15__4__Impl"
    // InternalGames.g:1634:1: rule__Game__Group_15__4__Impl : ( ']' ) ;
    public final void rule__Game__Group_15__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1638:1: ( ( ']' ) )
            // InternalGames.g:1639:1: ( ']' )
            {
            // InternalGames.g:1639:1: ( ']' )
            // InternalGames.g:1640:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_15_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_15_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15__4__Impl"


    // $ANTLR start "rule__Game__Group_15_3__0"
    // InternalGames.g:1650:1: rule__Game__Group_15_3__0 : rule__Game__Group_15_3__0__Impl rule__Game__Group_15_3__1 ;
    public final void rule__Game__Group_15_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1654:1: ( rule__Game__Group_15_3__0__Impl rule__Game__Group_15_3__1 )
            // InternalGames.g:1655:2: rule__Game__Group_15_3__0__Impl rule__Game__Group_15_3__1
            {
            pushFollow(FOLLOW_20);
            rule__Game__Group_15_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_15_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15_3__0"


    // $ANTLR start "rule__Game__Group_15_3__0__Impl"
    // InternalGames.g:1662:1: rule__Game__Group_15_3__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_15_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1666:1: ( ( ',' ) )
            // InternalGames.g:1667:1: ( ',' )
            {
            // InternalGames.g:1667:1: ( ',' )
            // InternalGames.g:1668:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_15_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_15_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15_3__0__Impl"


    // $ANTLR start "rule__Game__Group_15_3__1"
    // InternalGames.g:1677:1: rule__Game__Group_15_3__1 : rule__Game__Group_15_3__1__Impl ;
    public final void rule__Game__Group_15_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1681:1: ( rule__Game__Group_15_3__1__Impl )
            // InternalGames.g:1682:2: rule__Game__Group_15_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_15_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15_3__1"


    // $ANTLR start "rule__Game__Group_15_3__1__Impl"
    // InternalGames.g:1688:1: rule__Game__Group_15_3__1__Impl : ( ( rule__Game__ItemsAssignment_15_3_1 ) ) ;
    public final void rule__Game__Group_15_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1692:1: ( ( ( rule__Game__ItemsAssignment_15_3_1 ) ) )
            // InternalGames.g:1693:1: ( ( rule__Game__ItemsAssignment_15_3_1 ) )
            {
            // InternalGames.g:1693:1: ( ( rule__Game__ItemsAssignment_15_3_1 ) )
            // InternalGames.g:1694:2: ( rule__Game__ItemsAssignment_15_3_1 )
            {
             before(grammarAccess.getGameAccess().getItemsAssignment_15_3_1()); 
            // InternalGames.g:1695:2: ( rule__Game__ItemsAssignment_15_3_1 )
            // InternalGames.g:1695:3: rule__Game__ItemsAssignment_15_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__ItemsAssignment_15_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getItemsAssignment_15_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_15_3__1__Impl"


    // $ANTLR start "rule__Game__Group_19__0"
    // InternalGames.g:1704:1: rule__Game__Group_19__0 : rule__Game__Group_19__0__Impl rule__Game__Group_19__1 ;
    public final void rule__Game__Group_19__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1708:1: ( rule__Game__Group_19__0__Impl rule__Game__Group_19__1 )
            // InternalGames.g:1709:2: rule__Game__Group_19__0__Impl rule__Game__Group_19__1
            {
            pushFollow(FOLLOW_14);
            rule__Game__Group_19__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_19__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_19__0"


    // $ANTLR start "rule__Game__Group_19__0__Impl"
    // InternalGames.g:1716:1: rule__Game__Group_19__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_19__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1720:1: ( ( ',' ) )
            // InternalGames.g:1721:1: ( ',' )
            {
            // InternalGames.g:1721:1: ( ',' )
            // InternalGames.g:1722:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_19_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_19__0__Impl"


    // $ANTLR start "rule__Game__Group_19__1"
    // InternalGames.g:1731:1: rule__Game__Group_19__1 : rule__Game__Group_19__1__Impl ;
    public final void rule__Game__Group_19__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1735:1: ( rule__Game__Group_19__1__Impl )
            // InternalGames.g:1736:2: rule__Game__Group_19__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_19__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_19__1"


    // $ANTLR start "rule__Game__Group_19__1__Impl"
    // InternalGames.g:1742:1: rule__Game__Group_19__1__Impl : ( ( rule__Game__PathAssignment_19_1 ) ) ;
    public final void rule__Game__Group_19__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1746:1: ( ( ( rule__Game__PathAssignment_19_1 ) ) )
            // InternalGames.g:1747:1: ( ( rule__Game__PathAssignment_19_1 ) )
            {
            // InternalGames.g:1747:1: ( ( rule__Game__PathAssignment_19_1 ) )
            // InternalGames.g:1748:2: ( rule__Game__PathAssignment_19_1 )
            {
             before(grammarAccess.getGameAccess().getPathAssignment_19_1()); 
            // InternalGames.g:1749:2: ( rule__Game__PathAssignment_19_1 )
            // InternalGames.g:1749:3: rule__Game__PathAssignment_19_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__PathAssignment_19_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getPathAssignment_19_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_19__1__Impl"


    // $ANTLR start "rule__Game__Group_21__0"
    // InternalGames.g:1758:1: rule__Game__Group_21__0 : rule__Game__Group_21__0__Impl rule__Game__Group_21__1 ;
    public final void rule__Game__Group_21__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1762:1: ( rule__Game__Group_21__0__Impl rule__Game__Group_21__1 )
            // InternalGames.g:1763:2: rule__Game__Group_21__0__Impl rule__Game__Group_21__1
            {
            pushFollow(FOLLOW_7);
            rule__Game__Group_21__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_21__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__0"


    // $ANTLR start "rule__Game__Group_21__0__Impl"
    // InternalGames.g:1770:1: rule__Game__Group_21__0__Impl : ( 'recipes' ) ;
    public final void rule__Game__Group_21__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1774:1: ( ( 'recipes' ) )
            // InternalGames.g:1775:1: ( 'recipes' )
            {
            // InternalGames.g:1775:1: ( 'recipes' )
            // InternalGames.g:1776:2: 'recipes'
            {
             before(grammarAccess.getGameAccess().getRecipesKeyword_21_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRecipesKeyword_21_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__0__Impl"


    // $ANTLR start "rule__Game__Group_21__1"
    // InternalGames.g:1785:1: rule__Game__Group_21__1 : rule__Game__Group_21__1__Impl rule__Game__Group_21__2 ;
    public final void rule__Game__Group_21__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1789:1: ( rule__Game__Group_21__1__Impl rule__Game__Group_21__2 )
            // InternalGames.g:1790:2: rule__Game__Group_21__1__Impl rule__Game__Group_21__2
            {
            pushFollow(FOLLOW_21);
            rule__Game__Group_21__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_21__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__1"


    // $ANTLR start "rule__Game__Group_21__1__Impl"
    // InternalGames.g:1797:1: rule__Game__Group_21__1__Impl : ( '[' ) ;
    public final void rule__Game__Group_21__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1801:1: ( ( '[' ) )
            // InternalGames.g:1802:1: ( '[' )
            {
            // InternalGames.g:1802:1: ( '[' )
            // InternalGames.g:1803:2: '['
            {
             before(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_21_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getLeftSquareBracketKeyword_21_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__1__Impl"


    // $ANTLR start "rule__Game__Group_21__2"
    // InternalGames.g:1812:1: rule__Game__Group_21__2 : rule__Game__Group_21__2__Impl rule__Game__Group_21__3 ;
    public final void rule__Game__Group_21__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1816:1: ( rule__Game__Group_21__2__Impl rule__Game__Group_21__3 )
            // InternalGames.g:1817:2: rule__Game__Group_21__2__Impl rule__Game__Group_21__3
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_21__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_21__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__2"


    // $ANTLR start "rule__Game__Group_21__2__Impl"
    // InternalGames.g:1824:1: rule__Game__Group_21__2__Impl : ( ( rule__Game__RecipesAssignment_21_2 ) ) ;
    public final void rule__Game__Group_21__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1828:1: ( ( ( rule__Game__RecipesAssignment_21_2 ) ) )
            // InternalGames.g:1829:1: ( ( rule__Game__RecipesAssignment_21_2 ) )
            {
            // InternalGames.g:1829:1: ( ( rule__Game__RecipesAssignment_21_2 ) )
            // InternalGames.g:1830:2: ( rule__Game__RecipesAssignment_21_2 )
            {
             before(grammarAccess.getGameAccess().getRecipesAssignment_21_2()); 
            // InternalGames.g:1831:2: ( rule__Game__RecipesAssignment_21_2 )
            // InternalGames.g:1831:3: rule__Game__RecipesAssignment_21_2
            {
            pushFollow(FOLLOW_2);
            rule__Game__RecipesAssignment_21_2();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getRecipesAssignment_21_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__2__Impl"


    // $ANTLR start "rule__Game__Group_21__3"
    // InternalGames.g:1839:1: rule__Game__Group_21__3 : rule__Game__Group_21__3__Impl rule__Game__Group_21__4 ;
    public final void rule__Game__Group_21__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1843:1: ( rule__Game__Group_21__3__Impl rule__Game__Group_21__4 )
            // InternalGames.g:1844:2: rule__Game__Group_21__3__Impl rule__Game__Group_21__4
            {
            pushFollow(FOLLOW_9);
            rule__Game__Group_21__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_21__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__3"


    // $ANTLR start "rule__Game__Group_21__3__Impl"
    // InternalGames.g:1851:1: rule__Game__Group_21__3__Impl : ( ( rule__Game__Group_21_3__0 )* ) ;
    public final void rule__Game__Group_21__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1855:1: ( ( ( rule__Game__Group_21_3__0 )* ) )
            // InternalGames.g:1856:1: ( ( rule__Game__Group_21_3__0 )* )
            {
            // InternalGames.g:1856:1: ( ( rule__Game__Group_21_3__0 )* )
            // InternalGames.g:1857:2: ( rule__Game__Group_21_3__0 )*
            {
             before(grammarAccess.getGameAccess().getGroup_21_3()); 
            // InternalGames.g:1858:2: ( rule__Game__Group_21_3__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGames.g:1858:3: rule__Game__Group_21_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Game__Group_21_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getGameAccess().getGroup_21_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__3__Impl"


    // $ANTLR start "rule__Game__Group_21__4"
    // InternalGames.g:1866:1: rule__Game__Group_21__4 : rule__Game__Group_21__4__Impl ;
    public final void rule__Game__Group_21__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1870:1: ( rule__Game__Group_21__4__Impl )
            // InternalGames.g:1871:2: rule__Game__Group_21__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_21__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__4"


    // $ANTLR start "rule__Game__Group_21__4__Impl"
    // InternalGames.g:1877:1: rule__Game__Group_21__4__Impl : ( ']' ) ;
    public final void rule__Game__Group_21__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1881:1: ( ( ']' ) )
            // InternalGames.g:1882:1: ( ']' )
            {
            // InternalGames.g:1882:1: ( ']' )
            // InternalGames.g:1883:2: ']'
            {
             before(grammarAccess.getGameAccess().getRightSquareBracketKeyword_21_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getRightSquareBracketKeyword_21_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21__4__Impl"


    // $ANTLR start "rule__Game__Group_21_3__0"
    // InternalGames.g:1893:1: rule__Game__Group_21_3__0 : rule__Game__Group_21_3__0__Impl rule__Game__Group_21_3__1 ;
    public final void rule__Game__Group_21_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1897:1: ( rule__Game__Group_21_3__0__Impl rule__Game__Group_21_3__1 )
            // InternalGames.g:1898:2: rule__Game__Group_21_3__0__Impl rule__Game__Group_21_3__1
            {
            pushFollow(FOLLOW_21);
            rule__Game__Group_21_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Game__Group_21_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21_3__0"


    // $ANTLR start "rule__Game__Group_21_3__0__Impl"
    // InternalGames.g:1905:1: rule__Game__Group_21_3__0__Impl : ( ',' ) ;
    public final void rule__Game__Group_21_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1909:1: ( ( ',' ) )
            // InternalGames.g:1910:1: ( ',' )
            {
            // InternalGames.g:1910:1: ( ',' )
            // InternalGames.g:1911:2: ','
            {
             before(grammarAccess.getGameAccess().getCommaKeyword_21_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getCommaKeyword_21_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21_3__0__Impl"


    // $ANTLR start "rule__Game__Group_21_3__1"
    // InternalGames.g:1920:1: rule__Game__Group_21_3__1 : rule__Game__Group_21_3__1__Impl ;
    public final void rule__Game__Group_21_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1924:1: ( rule__Game__Group_21_3__1__Impl )
            // InternalGames.g:1925:2: rule__Game__Group_21_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Game__Group_21_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21_3__1"


    // $ANTLR start "rule__Game__Group_21_3__1__Impl"
    // InternalGames.g:1931:1: rule__Game__Group_21_3__1__Impl : ( ( rule__Game__RecipesAssignment_21_3_1 ) ) ;
    public final void rule__Game__Group_21_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1935:1: ( ( ( rule__Game__RecipesAssignment_21_3_1 ) ) )
            // InternalGames.g:1936:1: ( ( rule__Game__RecipesAssignment_21_3_1 ) )
            {
            // InternalGames.g:1936:1: ( ( rule__Game__RecipesAssignment_21_3_1 ) )
            // InternalGames.g:1937:2: ( rule__Game__RecipesAssignment_21_3_1 )
            {
             before(grammarAccess.getGameAccess().getRecipesAssignment_21_3_1()); 
            // InternalGames.g:1938:2: ( rule__Game__RecipesAssignment_21_3_1 )
            // InternalGames.g:1938:3: rule__Game__RecipesAssignment_21_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Game__RecipesAssignment_21_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGameAccess().getRecipesAssignment_21_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__Group_21_3__1__Impl"


    // $ANTLR start "rule__Difficulty__Group__0"
    // InternalGames.g:1947:1: rule__Difficulty__Group__0 : rule__Difficulty__Group__0__Impl rule__Difficulty__Group__1 ;
    public final void rule__Difficulty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1951:1: ( rule__Difficulty__Group__0__Impl rule__Difficulty__Group__1 )
            // InternalGames.g:1952:2: rule__Difficulty__Group__0__Impl rule__Difficulty__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Difficulty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__0"


    // $ANTLR start "rule__Difficulty__Group__0__Impl"
    // InternalGames.g:1959:1: rule__Difficulty__Group__0__Impl : ( 'difficulty' ) ;
    public final void rule__Difficulty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1963:1: ( ( 'difficulty' ) )
            // InternalGames.g:1964:1: ( 'difficulty' )
            {
            // InternalGames.g:1964:1: ( 'difficulty' )
            // InternalGames.g:1965:2: 'difficulty'
            {
             before(grammarAccess.getDifficultyAccess().getDifficultyKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getDifficultyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__0__Impl"


    // $ANTLR start "rule__Difficulty__Group__1"
    // InternalGames.g:1974:1: rule__Difficulty__Group__1 : rule__Difficulty__Group__1__Impl rule__Difficulty__Group__2 ;
    public final void rule__Difficulty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1978:1: ( rule__Difficulty__Group__1__Impl rule__Difficulty__Group__2 )
            // InternalGames.g:1979:2: rule__Difficulty__Group__1__Impl rule__Difficulty__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Difficulty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__1"


    // $ANTLR start "rule__Difficulty__Group__1__Impl"
    // InternalGames.g:1986:1: rule__Difficulty__Group__1__Impl : ( ( rule__Difficulty__LvlAssignment_1 ) ) ;
    public final void rule__Difficulty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:1990:1: ( ( ( rule__Difficulty__LvlAssignment_1 ) ) )
            // InternalGames.g:1991:1: ( ( rule__Difficulty__LvlAssignment_1 ) )
            {
            // InternalGames.g:1991:1: ( ( rule__Difficulty__LvlAssignment_1 ) )
            // InternalGames.g:1992:2: ( rule__Difficulty__LvlAssignment_1 )
            {
             before(grammarAccess.getDifficultyAccess().getLvlAssignment_1()); 
            // InternalGames.g:1993:2: ( rule__Difficulty__LvlAssignment_1 )
            // InternalGames.g:1993:3: rule__Difficulty__LvlAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__LvlAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDifficultyAccess().getLvlAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__1__Impl"


    // $ANTLR start "rule__Difficulty__Group__2"
    // InternalGames.g:2001:1: rule__Difficulty__Group__2 : rule__Difficulty__Group__2__Impl rule__Difficulty__Group__3 ;
    public final void rule__Difficulty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2005:1: ( rule__Difficulty__Group__2__Impl rule__Difficulty__Group__3 )
            // InternalGames.g:2006:2: rule__Difficulty__Group__2__Impl rule__Difficulty__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Difficulty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__2"


    // $ANTLR start "rule__Difficulty__Group__2__Impl"
    // InternalGames.g:2013:1: rule__Difficulty__Group__2__Impl : ( '{' ) ;
    public final void rule__Difficulty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2017:1: ( ( '{' ) )
            // InternalGames.g:2018:1: ( '{' )
            {
            // InternalGames.g:2018:1: ( '{' )
            // InternalGames.g:2019:2: '{'
            {
             before(grammarAccess.getDifficultyAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__2__Impl"


    // $ANTLR start "rule__Difficulty__Group__3"
    // InternalGames.g:2028:1: rule__Difficulty__Group__3 : rule__Difficulty__Group__3__Impl rule__Difficulty__Group__4 ;
    public final void rule__Difficulty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2032:1: ( rule__Difficulty__Group__3__Impl rule__Difficulty__Group__4 )
            // InternalGames.g:2033:2: rule__Difficulty__Group__3__Impl rule__Difficulty__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Difficulty__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__3"


    // $ANTLR start "rule__Difficulty__Group__3__Impl"
    // InternalGames.g:2040:1: rule__Difficulty__Group__3__Impl : ( 'sizeMax' ) ;
    public final void rule__Difficulty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2044:1: ( ( 'sizeMax' ) )
            // InternalGames.g:2045:1: ( 'sizeMax' )
            {
            // InternalGames.g:2045:1: ( 'sizeMax' )
            // InternalGames.g:2046:2: 'sizeMax'
            {
             before(grammarAccess.getDifficultyAccess().getSizeMaxKeyword_3()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getSizeMaxKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__3__Impl"


    // $ANTLR start "rule__Difficulty__Group__4"
    // InternalGames.g:2055:1: rule__Difficulty__Group__4 : rule__Difficulty__Group__4__Impl rule__Difficulty__Group__5 ;
    public final void rule__Difficulty__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2059:1: ( rule__Difficulty__Group__4__Impl rule__Difficulty__Group__5 )
            // InternalGames.g:2060:2: rule__Difficulty__Group__4__Impl rule__Difficulty__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Difficulty__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__4"


    // $ANTLR start "rule__Difficulty__Group__4__Impl"
    // InternalGames.g:2067:1: rule__Difficulty__Group__4__Impl : ( ( rule__Difficulty__SizeMaxAssignment_4 ) ) ;
    public final void rule__Difficulty__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2071:1: ( ( ( rule__Difficulty__SizeMaxAssignment_4 ) ) )
            // InternalGames.g:2072:1: ( ( rule__Difficulty__SizeMaxAssignment_4 ) )
            {
            // InternalGames.g:2072:1: ( ( rule__Difficulty__SizeMaxAssignment_4 ) )
            // InternalGames.g:2073:2: ( rule__Difficulty__SizeMaxAssignment_4 )
            {
             before(grammarAccess.getDifficultyAccess().getSizeMaxAssignment_4()); 
            // InternalGames.g:2074:2: ( rule__Difficulty__SizeMaxAssignment_4 )
            // InternalGames.g:2074:3: rule__Difficulty__SizeMaxAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__SizeMaxAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDifficultyAccess().getSizeMaxAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__4__Impl"


    // $ANTLR start "rule__Difficulty__Group__5"
    // InternalGames.g:2082:1: rule__Difficulty__Group__5 : rule__Difficulty__Group__5__Impl rule__Difficulty__Group__6 ;
    public final void rule__Difficulty__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2086:1: ( rule__Difficulty__Group__5__Impl rule__Difficulty__Group__6 )
            // InternalGames.g:2087:2: rule__Difficulty__Group__5__Impl rule__Difficulty__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__Difficulty__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__5"


    // $ANTLR start "rule__Difficulty__Group__5__Impl"
    // InternalGames.g:2094:1: rule__Difficulty__Group__5__Impl : ( ( rule__Difficulty__Group_5__0 )? ) ;
    public final void rule__Difficulty__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2098:1: ( ( ( rule__Difficulty__Group_5__0 )? ) )
            // InternalGames.g:2099:1: ( ( rule__Difficulty__Group_5__0 )? )
            {
            // InternalGames.g:2099:1: ( ( rule__Difficulty__Group_5__0 )? )
            // InternalGames.g:2100:2: ( rule__Difficulty__Group_5__0 )?
            {
             before(grammarAccess.getDifficultyAccess().getGroup_5()); 
            // InternalGames.g:2101:2: ( rule__Difficulty__Group_5__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalGames.g:2101:3: rule__Difficulty__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Difficulty__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDifficultyAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__5__Impl"


    // $ANTLR start "rule__Difficulty__Group__6"
    // InternalGames.g:2109:1: rule__Difficulty__Group__6 : rule__Difficulty__Group__6__Impl rule__Difficulty__Group__7 ;
    public final void rule__Difficulty__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2113:1: ( rule__Difficulty__Group__6__Impl rule__Difficulty__Group__7 )
            // InternalGames.g:2114:2: rule__Difficulty__Group__6__Impl rule__Difficulty__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__Difficulty__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__6"


    // $ANTLR start "rule__Difficulty__Group__6__Impl"
    // InternalGames.g:2121:1: rule__Difficulty__Group__6__Impl : ( ( rule__Difficulty__Group_6__0 )? ) ;
    public final void rule__Difficulty__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2125:1: ( ( ( rule__Difficulty__Group_6__0 )? ) )
            // InternalGames.g:2126:1: ( ( rule__Difficulty__Group_6__0 )? )
            {
            // InternalGames.g:2126:1: ( ( rule__Difficulty__Group_6__0 )? )
            // InternalGames.g:2127:2: ( rule__Difficulty__Group_6__0 )?
            {
             before(grammarAccess.getDifficultyAccess().getGroup_6()); 
            // InternalGames.g:2128:2: ( rule__Difficulty__Group_6__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalGames.g:2128:3: rule__Difficulty__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Difficulty__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDifficultyAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__6__Impl"


    // $ANTLR start "rule__Difficulty__Group__7"
    // InternalGames.g:2136:1: rule__Difficulty__Group__7 : rule__Difficulty__Group__7__Impl ;
    public final void rule__Difficulty__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2140:1: ( rule__Difficulty__Group__7__Impl )
            // InternalGames.g:2141:2: rule__Difficulty__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__7"


    // $ANTLR start "rule__Difficulty__Group__7__Impl"
    // InternalGames.g:2147:1: rule__Difficulty__Group__7__Impl : ( '}' ) ;
    public final void rule__Difficulty__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2151:1: ( ( '}' ) )
            // InternalGames.g:2152:1: ( '}' )
            {
            // InternalGames.g:2152:1: ( '}' )
            // InternalGames.g:2153:2: '}'
            {
             before(grammarAccess.getDifficultyAccess().getRightCurlyBracketKeyword_7()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group__7__Impl"


    // $ANTLR start "rule__Difficulty__Group_5__0"
    // InternalGames.g:2163:1: rule__Difficulty__Group_5__0 : rule__Difficulty__Group_5__0__Impl rule__Difficulty__Group_5__1 ;
    public final void rule__Difficulty__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2167:1: ( rule__Difficulty__Group_5__0__Impl rule__Difficulty__Group_5__1 )
            // InternalGames.g:2168:2: rule__Difficulty__Group_5__0__Impl rule__Difficulty__Group_5__1
            {
            pushFollow(FOLLOW_7);
            rule__Difficulty__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__0"


    // $ANTLR start "rule__Difficulty__Group_5__0__Impl"
    // InternalGames.g:2175:1: rule__Difficulty__Group_5__0__Impl : ( 'items' ) ;
    public final void rule__Difficulty__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2179:1: ( ( 'items' ) )
            // InternalGames.g:2180:1: ( 'items' )
            {
            // InternalGames.g:2180:1: ( 'items' )
            // InternalGames.g:2181:2: 'items'
            {
             before(grammarAccess.getDifficultyAccess().getItemsKeyword_5_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getItemsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__0__Impl"


    // $ANTLR start "rule__Difficulty__Group_5__1"
    // InternalGames.g:2190:1: rule__Difficulty__Group_5__1 : rule__Difficulty__Group_5__1__Impl rule__Difficulty__Group_5__2 ;
    public final void rule__Difficulty__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2194:1: ( rule__Difficulty__Group_5__1__Impl rule__Difficulty__Group_5__2 )
            // InternalGames.g:2195:2: rule__Difficulty__Group_5__1__Impl rule__Difficulty__Group_5__2
            {
            pushFollow(FOLLOW_3);
            rule__Difficulty__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__1"


    // $ANTLR start "rule__Difficulty__Group_5__1__Impl"
    // InternalGames.g:2202:1: rule__Difficulty__Group_5__1__Impl : ( '[' ) ;
    public final void rule__Difficulty__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2206:1: ( ( '[' ) )
            // InternalGames.g:2207:1: ( '[' )
            {
            // InternalGames.g:2207:1: ( '[' )
            // InternalGames.g:2208:2: '['
            {
             before(grammarAccess.getDifficultyAccess().getLeftSquareBracketKeyword_5_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getLeftSquareBracketKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__1__Impl"


    // $ANTLR start "rule__Difficulty__Group_5__2"
    // InternalGames.g:2217:1: rule__Difficulty__Group_5__2 : rule__Difficulty__Group_5__2__Impl rule__Difficulty__Group_5__3 ;
    public final void rule__Difficulty__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2221:1: ( rule__Difficulty__Group_5__2__Impl rule__Difficulty__Group_5__3 )
            // InternalGames.g:2222:2: rule__Difficulty__Group_5__2__Impl rule__Difficulty__Group_5__3
            {
            pushFollow(FOLLOW_9);
            rule__Difficulty__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__2"


    // $ANTLR start "rule__Difficulty__Group_5__2__Impl"
    // InternalGames.g:2229:1: rule__Difficulty__Group_5__2__Impl : ( ( rule__Difficulty__ItemsAssignment_5_2 ) ) ;
    public final void rule__Difficulty__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2233:1: ( ( ( rule__Difficulty__ItemsAssignment_5_2 ) ) )
            // InternalGames.g:2234:1: ( ( rule__Difficulty__ItemsAssignment_5_2 ) )
            {
            // InternalGames.g:2234:1: ( ( rule__Difficulty__ItemsAssignment_5_2 ) )
            // InternalGames.g:2235:2: ( rule__Difficulty__ItemsAssignment_5_2 )
            {
             before(grammarAccess.getDifficultyAccess().getItemsAssignment_5_2()); 
            // InternalGames.g:2236:2: ( rule__Difficulty__ItemsAssignment_5_2 )
            // InternalGames.g:2236:3: rule__Difficulty__ItemsAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__ItemsAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getDifficultyAccess().getItemsAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__2__Impl"


    // $ANTLR start "rule__Difficulty__Group_5__3"
    // InternalGames.g:2244:1: rule__Difficulty__Group_5__3 : rule__Difficulty__Group_5__3__Impl rule__Difficulty__Group_5__4 ;
    public final void rule__Difficulty__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2248:1: ( rule__Difficulty__Group_5__3__Impl rule__Difficulty__Group_5__4 )
            // InternalGames.g:2249:2: rule__Difficulty__Group_5__3__Impl rule__Difficulty__Group_5__4
            {
            pushFollow(FOLLOW_9);
            rule__Difficulty__Group_5__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__3"


    // $ANTLR start "rule__Difficulty__Group_5__3__Impl"
    // InternalGames.g:2256:1: rule__Difficulty__Group_5__3__Impl : ( ( rule__Difficulty__Group_5_3__0 )* ) ;
    public final void rule__Difficulty__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2260:1: ( ( ( rule__Difficulty__Group_5_3__0 )* ) )
            // InternalGames.g:2261:1: ( ( rule__Difficulty__Group_5_3__0 )* )
            {
            // InternalGames.g:2261:1: ( ( rule__Difficulty__Group_5_3__0 )* )
            // InternalGames.g:2262:2: ( rule__Difficulty__Group_5_3__0 )*
            {
             before(grammarAccess.getDifficultyAccess().getGroup_5_3()); 
            // InternalGames.g:2263:2: ( rule__Difficulty__Group_5_3__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==25) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalGames.g:2263:3: rule__Difficulty__Group_5_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Difficulty__Group_5_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getDifficultyAccess().getGroup_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__3__Impl"


    // $ANTLR start "rule__Difficulty__Group_5__4"
    // InternalGames.g:2271:1: rule__Difficulty__Group_5__4 : rule__Difficulty__Group_5__4__Impl ;
    public final void rule__Difficulty__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2275:1: ( rule__Difficulty__Group_5__4__Impl )
            // InternalGames.g:2276:2: rule__Difficulty__Group_5__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__4"


    // $ANTLR start "rule__Difficulty__Group_5__4__Impl"
    // InternalGames.g:2282:1: rule__Difficulty__Group_5__4__Impl : ( ']' ) ;
    public final void rule__Difficulty__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2286:1: ( ( ']' ) )
            // InternalGames.g:2287:1: ( ']' )
            {
            // InternalGames.g:2287:1: ( ']' )
            // InternalGames.g:2288:2: ']'
            {
             before(grammarAccess.getDifficultyAccess().getRightSquareBracketKeyword_5_4()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getRightSquareBracketKeyword_5_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5__4__Impl"


    // $ANTLR start "rule__Difficulty__Group_5_3__0"
    // InternalGames.g:2298:1: rule__Difficulty__Group_5_3__0 : rule__Difficulty__Group_5_3__0__Impl rule__Difficulty__Group_5_3__1 ;
    public final void rule__Difficulty__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2302:1: ( rule__Difficulty__Group_5_3__0__Impl rule__Difficulty__Group_5_3__1 )
            // InternalGames.g:2303:2: rule__Difficulty__Group_5_3__0__Impl rule__Difficulty__Group_5_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Difficulty__Group_5_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5_3__0"


    // $ANTLR start "rule__Difficulty__Group_5_3__0__Impl"
    // InternalGames.g:2310:1: rule__Difficulty__Group_5_3__0__Impl : ( ',' ) ;
    public final void rule__Difficulty__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2314:1: ( ( ',' ) )
            // InternalGames.g:2315:1: ( ',' )
            {
            // InternalGames.g:2315:1: ( ',' )
            // InternalGames.g:2316:2: ','
            {
             before(grammarAccess.getDifficultyAccess().getCommaKeyword_5_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getCommaKeyword_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5_3__0__Impl"


    // $ANTLR start "rule__Difficulty__Group_5_3__1"
    // InternalGames.g:2325:1: rule__Difficulty__Group_5_3__1 : rule__Difficulty__Group_5_3__1__Impl ;
    public final void rule__Difficulty__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2329:1: ( rule__Difficulty__Group_5_3__1__Impl )
            // InternalGames.g:2330:2: rule__Difficulty__Group_5_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_5_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5_3__1"


    // $ANTLR start "rule__Difficulty__Group_5_3__1__Impl"
    // InternalGames.g:2336:1: rule__Difficulty__Group_5_3__1__Impl : ( ( rule__Difficulty__ItemsAssignment_5_3_1 ) ) ;
    public final void rule__Difficulty__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2340:1: ( ( ( rule__Difficulty__ItemsAssignment_5_3_1 ) ) )
            // InternalGames.g:2341:1: ( ( rule__Difficulty__ItemsAssignment_5_3_1 ) )
            {
            // InternalGames.g:2341:1: ( ( rule__Difficulty__ItemsAssignment_5_3_1 ) )
            // InternalGames.g:2342:2: ( rule__Difficulty__ItemsAssignment_5_3_1 )
            {
             before(grammarAccess.getDifficultyAccess().getItemsAssignment_5_3_1()); 
            // InternalGames.g:2343:2: ( rule__Difficulty__ItemsAssignment_5_3_1 )
            // InternalGames.g:2343:3: rule__Difficulty__ItemsAssignment_5_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__ItemsAssignment_5_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDifficultyAccess().getItemsAssignment_5_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_5_3__1__Impl"


    // $ANTLR start "rule__Difficulty__Group_6__0"
    // InternalGames.g:2352:1: rule__Difficulty__Group_6__0 : rule__Difficulty__Group_6__0__Impl rule__Difficulty__Group_6__1 ;
    public final void rule__Difficulty__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2356:1: ( rule__Difficulty__Group_6__0__Impl rule__Difficulty__Group_6__1 )
            // InternalGames.g:2357:2: rule__Difficulty__Group_6__0__Impl rule__Difficulty__Group_6__1
            {
            pushFollow(FOLLOW_3);
            rule__Difficulty__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_6__0"


    // $ANTLR start "rule__Difficulty__Group_6__0__Impl"
    // InternalGames.g:2364:1: rule__Difficulty__Group_6__0__Impl : ( 'knowledge' ) ;
    public final void rule__Difficulty__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2368:1: ( ( 'knowledge' ) )
            // InternalGames.g:2369:1: ( 'knowledge' )
            {
            // InternalGames.g:2369:1: ( 'knowledge' )
            // InternalGames.g:2370:2: 'knowledge'
            {
             before(grammarAccess.getDifficultyAccess().getKnowledgeKeyword_6_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getKnowledgeKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_6__0__Impl"


    // $ANTLR start "rule__Difficulty__Group_6__1"
    // InternalGames.g:2379:1: rule__Difficulty__Group_6__1 : rule__Difficulty__Group_6__1__Impl ;
    public final void rule__Difficulty__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2383:1: ( rule__Difficulty__Group_6__1__Impl )
            // InternalGames.g:2384:2: rule__Difficulty__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Difficulty__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_6__1"


    // $ANTLR start "rule__Difficulty__Group_6__1__Impl"
    // InternalGames.g:2390:1: rule__Difficulty__Group_6__1__Impl : ( ( rule__Difficulty__KnowledgesAssignment_6_1 )* ) ;
    public final void rule__Difficulty__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2394:1: ( ( ( rule__Difficulty__KnowledgesAssignment_6_1 )* ) )
            // InternalGames.g:2395:1: ( ( rule__Difficulty__KnowledgesAssignment_6_1 )* )
            {
            // InternalGames.g:2395:1: ( ( rule__Difficulty__KnowledgesAssignment_6_1 )* )
            // InternalGames.g:2396:2: ( rule__Difficulty__KnowledgesAssignment_6_1 )*
            {
             before(grammarAccess.getDifficultyAccess().getKnowledgesAssignment_6_1()); 
            // InternalGames.g:2397:2: ( rule__Difficulty__KnowledgesAssignment_6_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalGames.g:2397:3: rule__Difficulty__KnowledgesAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Difficulty__KnowledgesAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getDifficultyAccess().getKnowledgesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__Group_6__1__Impl"


    // $ANTLR start "rule__Player__Group__0"
    // InternalGames.g:2406:1: rule__Player__Group__0 : rule__Player__Group__0__Impl rule__Player__Group__1 ;
    public final void rule__Player__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2410:1: ( rule__Player__Group__0__Impl rule__Player__Group__1 )
            // InternalGames.g:2411:2: rule__Player__Group__0__Impl rule__Player__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Player__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__0"


    // $ANTLR start "rule__Player__Group__0__Impl"
    // InternalGames.g:2418:1: rule__Player__Group__0__Impl : ( 'player' ) ;
    public final void rule__Player__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2422:1: ( ( 'player' ) )
            // InternalGames.g:2423:1: ( 'player' )
            {
            // InternalGames.g:2423:1: ( 'player' )
            // InternalGames.g:2424:2: 'player'
            {
             before(grammarAccess.getPlayerAccess().getPlayerKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getPlayerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__0__Impl"


    // $ANTLR start "rule__Player__Group__1"
    // InternalGames.g:2433:1: rule__Player__Group__1 : rule__Player__Group__1__Impl rule__Player__Group__2 ;
    public final void rule__Player__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2437:1: ( rule__Player__Group__1__Impl rule__Player__Group__2 )
            // InternalGames.g:2438:2: rule__Player__Group__1__Impl rule__Player__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Player__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__1"


    // $ANTLR start "rule__Player__Group__1__Impl"
    // InternalGames.g:2445:1: rule__Player__Group__1__Impl : ( ( rule__Player__NameAssignment_1 ) ) ;
    public final void rule__Player__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2449:1: ( ( ( rule__Player__NameAssignment_1 ) ) )
            // InternalGames.g:2450:1: ( ( rule__Player__NameAssignment_1 ) )
            {
            // InternalGames.g:2450:1: ( ( rule__Player__NameAssignment_1 ) )
            // InternalGames.g:2451:2: ( rule__Player__NameAssignment_1 )
            {
             before(grammarAccess.getPlayerAccess().getNameAssignment_1()); 
            // InternalGames.g:2452:2: ( rule__Player__NameAssignment_1 )
            // InternalGames.g:2452:3: rule__Player__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Player__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPlayerAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__1__Impl"


    // $ANTLR start "rule__Player__Group__2"
    // InternalGames.g:2460:1: rule__Player__Group__2 : rule__Player__Group__2__Impl rule__Player__Group__3 ;
    public final void rule__Player__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2464:1: ( rule__Player__Group__2__Impl rule__Player__Group__3 )
            // InternalGames.g:2465:2: rule__Player__Group__2__Impl rule__Player__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__Player__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__2"


    // $ANTLR start "rule__Player__Group__2__Impl"
    // InternalGames.g:2472:1: rule__Player__Group__2__Impl : ( '{' ) ;
    public final void rule__Player__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2476:1: ( ( '{' ) )
            // InternalGames.g:2477:1: ( '{' )
            {
            // InternalGames.g:2477:1: ( '{' )
            // InternalGames.g:2478:2: '{'
            {
             before(grammarAccess.getPlayerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__2__Impl"


    // $ANTLR start "rule__Player__Group__3"
    // InternalGames.g:2487:1: rule__Player__Group__3 : rule__Player__Group__3__Impl rule__Player__Group__4 ;
    public final void rule__Player__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2491:1: ( rule__Player__Group__3__Impl rule__Player__Group__4 )
            // InternalGames.g:2492:2: rule__Player__Group__3__Impl rule__Player__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Player__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__3"


    // $ANTLR start "rule__Player__Group__3__Impl"
    // InternalGames.g:2499:1: rule__Player__Group__3__Impl : ( ( rule__Player__Group_3__0 )? ) ;
    public final void rule__Player__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2503:1: ( ( ( rule__Player__Group_3__0 )? ) )
            // InternalGames.g:2504:1: ( ( rule__Player__Group_3__0 )? )
            {
            // InternalGames.g:2504:1: ( ( rule__Player__Group_3__0 )? )
            // InternalGames.g:2505:2: ( rule__Player__Group_3__0 )?
            {
             before(grammarAccess.getPlayerAccess().getGroup_3()); 
            // InternalGames.g:2506:2: ( rule__Player__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalGames.g:2506:3: rule__Player__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Player__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlayerAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__3__Impl"


    // $ANTLR start "rule__Player__Group__4"
    // InternalGames.g:2514:1: rule__Player__Group__4 : rule__Player__Group__4__Impl rule__Player__Group__5 ;
    public final void rule__Player__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2518:1: ( rule__Player__Group__4__Impl rule__Player__Group__5 )
            // InternalGames.g:2519:2: rule__Player__Group__4__Impl rule__Player__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Player__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__4"


    // $ANTLR start "rule__Player__Group__4__Impl"
    // InternalGames.g:2526:1: rule__Player__Group__4__Impl : ( ( rule__Player__Group_4__0 )? ) ;
    public final void rule__Player__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2530:1: ( ( ( rule__Player__Group_4__0 )? ) )
            // InternalGames.g:2531:1: ( ( rule__Player__Group_4__0 )? )
            {
            // InternalGames.g:2531:1: ( ( rule__Player__Group_4__0 )? )
            // InternalGames.g:2532:2: ( rule__Player__Group_4__0 )?
            {
             before(grammarAccess.getPlayerAccess().getGroup_4()); 
            // InternalGames.g:2533:2: ( rule__Player__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalGames.g:2533:3: rule__Player__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Player__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlayerAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__4__Impl"


    // $ANTLR start "rule__Player__Group__5"
    // InternalGames.g:2541:1: rule__Player__Group__5 : rule__Player__Group__5__Impl ;
    public final void rule__Player__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2545:1: ( rule__Player__Group__5__Impl )
            // InternalGames.g:2546:2: rule__Player__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Player__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__5"


    // $ANTLR start "rule__Player__Group__5__Impl"
    // InternalGames.g:2552:1: rule__Player__Group__5__Impl : ( '}' ) ;
    public final void rule__Player__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2556:1: ( ( '}' ) )
            // InternalGames.g:2557:1: ( '}' )
            {
            // InternalGames.g:2557:1: ( '}' )
            // InternalGames.g:2558:2: '}'
            {
             before(grammarAccess.getPlayerAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group__5__Impl"


    // $ANTLR start "rule__Player__Group_3__0"
    // InternalGames.g:2568:1: rule__Player__Group_3__0 : rule__Player__Group_3__0__Impl rule__Player__Group_3__1 ;
    public final void rule__Player__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2572:1: ( rule__Player__Group_3__0__Impl rule__Player__Group_3__1 )
            // InternalGames.g:2573:2: rule__Player__Group_3__0__Impl rule__Player__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Player__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_3__0"


    // $ANTLR start "rule__Player__Group_3__0__Impl"
    // InternalGames.g:2580:1: rule__Player__Group_3__0__Impl : ( 'items' ) ;
    public final void rule__Player__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2584:1: ( ( 'items' ) )
            // InternalGames.g:2585:1: ( 'items' )
            {
            // InternalGames.g:2585:1: ( 'items' )
            // InternalGames.g:2586:2: 'items'
            {
             before(grammarAccess.getPlayerAccess().getItemsKeyword_3_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getItemsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_3__0__Impl"


    // $ANTLR start "rule__Player__Group_3__1"
    // InternalGames.g:2595:1: rule__Player__Group_3__1 : rule__Player__Group_3__1__Impl ;
    public final void rule__Player__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2599:1: ( rule__Player__Group_3__1__Impl )
            // InternalGames.g:2600:2: rule__Player__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Player__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_3__1"


    // $ANTLR start "rule__Player__Group_3__1__Impl"
    // InternalGames.g:2606:1: rule__Player__Group_3__1__Impl : ( ( rule__Player__ItemsAssignment_3_1 )* ) ;
    public final void rule__Player__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2610:1: ( ( ( rule__Player__ItemsAssignment_3_1 )* ) )
            // InternalGames.g:2611:1: ( ( rule__Player__ItemsAssignment_3_1 )* )
            {
            // InternalGames.g:2611:1: ( ( rule__Player__ItemsAssignment_3_1 )* )
            // InternalGames.g:2612:2: ( rule__Player__ItemsAssignment_3_1 )*
            {
             before(grammarAccess.getPlayerAccess().getItemsAssignment_3_1()); 
            // InternalGames.g:2613:2: ( rule__Player__ItemsAssignment_3_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalGames.g:2613:3: rule__Player__ItemsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Player__ItemsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getPlayerAccess().getItemsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_3__1__Impl"


    // $ANTLR start "rule__Player__Group_4__0"
    // InternalGames.g:2622:1: rule__Player__Group_4__0 : rule__Player__Group_4__0__Impl rule__Player__Group_4__1 ;
    public final void rule__Player__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2626:1: ( rule__Player__Group_4__0__Impl rule__Player__Group_4__1 )
            // InternalGames.g:2627:2: rule__Player__Group_4__0__Impl rule__Player__Group_4__1
            {
            pushFollow(FOLLOW_3);
            rule__Player__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Player__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_4__0"


    // $ANTLR start "rule__Player__Group_4__0__Impl"
    // InternalGames.g:2634:1: rule__Player__Group_4__0__Impl : ( 'knowledge' ) ;
    public final void rule__Player__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2638:1: ( ( 'knowledge' ) )
            // InternalGames.g:2639:1: ( 'knowledge' )
            {
            // InternalGames.g:2639:1: ( 'knowledge' )
            // InternalGames.g:2640:2: 'knowledge'
            {
             before(grammarAccess.getPlayerAccess().getKnowledgeKeyword_4_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getKnowledgeKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_4__0__Impl"


    // $ANTLR start "rule__Player__Group_4__1"
    // InternalGames.g:2649:1: rule__Player__Group_4__1 : rule__Player__Group_4__1__Impl ;
    public final void rule__Player__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2653:1: ( rule__Player__Group_4__1__Impl )
            // InternalGames.g:2654:2: rule__Player__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Player__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_4__1"


    // $ANTLR start "rule__Player__Group_4__1__Impl"
    // InternalGames.g:2660:1: rule__Player__Group_4__1__Impl : ( ( rule__Player__KnowledgeAssignment_4_1 )* ) ;
    public final void rule__Player__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2664:1: ( ( ( rule__Player__KnowledgeAssignment_4_1 )* ) )
            // InternalGames.g:2665:1: ( ( rule__Player__KnowledgeAssignment_4_1 )* )
            {
            // InternalGames.g:2665:1: ( ( rule__Player__KnowledgeAssignment_4_1 )* )
            // InternalGames.g:2666:2: ( rule__Player__KnowledgeAssignment_4_1 )*
            {
             before(grammarAccess.getPlayerAccess().getKnowledgeAssignment_4_1()); 
            // InternalGames.g:2667:2: ( rule__Player__KnowledgeAssignment_4_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalGames.g:2667:3: rule__Player__KnowledgeAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Player__KnowledgeAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getPlayerAccess().getKnowledgeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__Group_4__1__Impl"


    // $ANTLR start "rule__People__Group__0"
    // InternalGames.g:2676:1: rule__People__Group__0 : rule__People__Group__0__Impl rule__People__Group__1 ;
    public final void rule__People__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2680:1: ( rule__People__Group__0__Impl rule__People__Group__1 )
            // InternalGames.g:2681:2: rule__People__Group__0__Impl rule__People__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__People__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__0"


    // $ANTLR start "rule__People__Group__0__Impl"
    // InternalGames.g:2688:1: rule__People__Group__0__Impl : ( 'people' ) ;
    public final void rule__People__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2692:1: ( ( 'people' ) )
            // InternalGames.g:2693:1: ( 'people' )
            {
            // InternalGames.g:2693:1: ( 'people' )
            // InternalGames.g:2694:2: 'people'
            {
             before(grammarAccess.getPeopleAccess().getPeopleKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getPeopleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__0__Impl"


    // $ANTLR start "rule__People__Group__1"
    // InternalGames.g:2703:1: rule__People__Group__1 : rule__People__Group__1__Impl rule__People__Group__2 ;
    public final void rule__People__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2707:1: ( rule__People__Group__1__Impl rule__People__Group__2 )
            // InternalGames.g:2708:2: rule__People__Group__1__Impl rule__People__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__People__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__1"


    // $ANTLR start "rule__People__Group__1__Impl"
    // InternalGames.g:2715:1: rule__People__Group__1__Impl : ( ( rule__People__NameAssignment_1 ) ) ;
    public final void rule__People__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2719:1: ( ( ( rule__People__NameAssignment_1 ) ) )
            // InternalGames.g:2720:1: ( ( rule__People__NameAssignment_1 ) )
            {
            // InternalGames.g:2720:1: ( ( rule__People__NameAssignment_1 ) )
            // InternalGames.g:2721:2: ( rule__People__NameAssignment_1 )
            {
             before(grammarAccess.getPeopleAccess().getNameAssignment_1()); 
            // InternalGames.g:2722:2: ( rule__People__NameAssignment_1 )
            // InternalGames.g:2722:3: rule__People__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__People__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__1__Impl"


    // $ANTLR start "rule__People__Group__2"
    // InternalGames.g:2730:1: rule__People__Group__2 : rule__People__Group__2__Impl rule__People__Group__3 ;
    public final void rule__People__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2734:1: ( rule__People__Group__2__Impl rule__People__Group__3 )
            // InternalGames.g:2735:2: rule__People__Group__2__Impl rule__People__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__People__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__2"


    // $ANTLR start "rule__People__Group__2__Impl"
    // InternalGames.g:2742:1: rule__People__Group__2__Impl : ( '{' ) ;
    public final void rule__People__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2746:1: ( ( '{' ) )
            // InternalGames.g:2747:1: ( '{' )
            {
            // InternalGames.g:2747:1: ( '{' )
            // InternalGames.g:2748:2: '{'
            {
             before(grammarAccess.getPeopleAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__2__Impl"


    // $ANTLR start "rule__People__Group__3"
    // InternalGames.g:2757:1: rule__People__Group__3 : rule__People__Group__3__Impl rule__People__Group__4 ;
    public final void rule__People__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2761:1: ( rule__People__Group__3__Impl rule__People__Group__4 )
            // InternalGames.g:2762:2: rule__People__Group__3__Impl rule__People__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__People__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__3"


    // $ANTLR start "rule__People__Group__3__Impl"
    // InternalGames.g:2769:1: rule__People__Group__3__Impl : ( 'description' ) ;
    public final void rule__People__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2773:1: ( ( 'description' ) )
            // InternalGames.g:2774:1: ( 'description' )
            {
            // InternalGames.g:2774:1: ( 'description' )
            // InternalGames.g:2775:2: 'description'
            {
             before(grammarAccess.getPeopleAccess().getDescriptionKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getDescriptionKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__3__Impl"


    // $ANTLR start "rule__People__Group__4"
    // InternalGames.g:2784:1: rule__People__Group__4 : rule__People__Group__4__Impl rule__People__Group__5 ;
    public final void rule__People__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2788:1: ( rule__People__Group__4__Impl rule__People__Group__5 )
            // InternalGames.g:2789:2: rule__People__Group__4__Impl rule__People__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__People__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__4"


    // $ANTLR start "rule__People__Group__4__Impl"
    // InternalGames.g:2796:1: rule__People__Group__4__Impl : ( ( rule__People__DescriptionAssignment_4 ) ) ;
    public final void rule__People__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2800:1: ( ( ( rule__People__DescriptionAssignment_4 ) ) )
            // InternalGames.g:2801:1: ( ( rule__People__DescriptionAssignment_4 ) )
            {
            // InternalGames.g:2801:1: ( ( rule__People__DescriptionAssignment_4 ) )
            // InternalGames.g:2802:2: ( rule__People__DescriptionAssignment_4 )
            {
             before(grammarAccess.getPeopleAccess().getDescriptionAssignment_4()); 
            // InternalGames.g:2803:2: ( rule__People__DescriptionAssignment_4 )
            // InternalGames.g:2803:3: rule__People__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__People__DescriptionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getDescriptionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__4__Impl"


    // $ANTLR start "rule__People__Group__5"
    // InternalGames.g:2811:1: rule__People__Group__5 : rule__People__Group__5__Impl rule__People__Group__6 ;
    public final void rule__People__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2815:1: ( rule__People__Group__5__Impl rule__People__Group__6 )
            // InternalGames.g:2816:2: rule__People__Group__5__Impl rule__People__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__People__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__5"


    // $ANTLR start "rule__People__Group__5__Impl"
    // InternalGames.g:2823:1: rule__People__Group__5__Impl : ( 'visible' ) ;
    public final void rule__People__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2827:1: ( ( 'visible' ) )
            // InternalGames.g:2828:1: ( 'visible' )
            {
            // InternalGames.g:2828:1: ( 'visible' )
            // InternalGames.g:2829:2: 'visible'
            {
             before(grammarAccess.getPeopleAccess().getVisibleKeyword_5()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getVisibleKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__5__Impl"


    // $ANTLR start "rule__People__Group__6"
    // InternalGames.g:2838:1: rule__People__Group__6 : rule__People__Group__6__Impl rule__People__Group__7 ;
    public final void rule__People__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2842:1: ( rule__People__Group__6__Impl rule__People__Group__7 )
            // InternalGames.g:2843:2: rule__People__Group__6__Impl rule__People__Group__7
            {
            pushFollow(FOLLOW_29);
            rule__People__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__6"


    // $ANTLR start "rule__People__Group__6__Impl"
    // InternalGames.g:2850:1: rule__People__Group__6__Impl : ( ( rule__People__VisibleAssignment_6 ) ) ;
    public final void rule__People__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2854:1: ( ( ( rule__People__VisibleAssignment_6 ) ) )
            // InternalGames.g:2855:1: ( ( rule__People__VisibleAssignment_6 ) )
            {
            // InternalGames.g:2855:1: ( ( rule__People__VisibleAssignment_6 ) )
            // InternalGames.g:2856:2: ( rule__People__VisibleAssignment_6 )
            {
             before(grammarAccess.getPeopleAccess().getVisibleAssignment_6()); 
            // InternalGames.g:2857:2: ( rule__People__VisibleAssignment_6 )
            // InternalGames.g:2857:3: rule__People__VisibleAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__People__VisibleAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getVisibleAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__6__Impl"


    // $ANTLR start "rule__People__Group__7"
    // InternalGames.g:2865:1: rule__People__Group__7 : rule__People__Group__7__Impl rule__People__Group__8 ;
    public final void rule__People__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2869:1: ( rule__People__Group__7__Impl rule__People__Group__8 )
            // InternalGames.g:2870:2: rule__People__Group__7__Impl rule__People__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__People__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__7"


    // $ANTLR start "rule__People__Group__7__Impl"
    // InternalGames.g:2877:1: rule__People__Group__7__Impl : ( ( rule__People__Group_7__0 )? ) ;
    public final void rule__People__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2881:1: ( ( ( rule__People__Group_7__0 )? ) )
            // InternalGames.g:2882:1: ( ( rule__People__Group_7__0 )? )
            {
            // InternalGames.g:2882:1: ( ( rule__People__Group_7__0 )? )
            // InternalGames.g:2883:2: ( rule__People__Group_7__0 )?
            {
             before(grammarAccess.getPeopleAccess().getGroup_7()); 
            // InternalGames.g:2884:2: ( rule__People__Group_7__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalGames.g:2884:3: rule__People__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__People__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPeopleAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__7__Impl"


    // $ANTLR start "rule__People__Group__8"
    // InternalGames.g:2892:1: rule__People__Group__8 : rule__People__Group__8__Impl rule__People__Group__9 ;
    public final void rule__People__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2896:1: ( rule__People__Group__8__Impl rule__People__Group__9 )
            // InternalGames.g:2897:2: rule__People__Group__8__Impl rule__People__Group__9
            {
            pushFollow(FOLLOW_22);
            rule__People__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__8"


    // $ANTLR start "rule__People__Group__8__Impl"
    // InternalGames.g:2904:1: rule__People__Group__8__Impl : ( 'active' ) ;
    public final void rule__People__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2908:1: ( ( 'active' ) )
            // InternalGames.g:2909:1: ( 'active' )
            {
            // InternalGames.g:2909:1: ( 'active' )
            // InternalGames.g:2910:2: 'active'
            {
             before(grammarAccess.getPeopleAccess().getActiveKeyword_8()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getActiveKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__8__Impl"


    // $ANTLR start "rule__People__Group__9"
    // InternalGames.g:2919:1: rule__People__Group__9 : rule__People__Group__9__Impl rule__People__Group__10 ;
    public final void rule__People__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2923:1: ( rule__People__Group__9__Impl rule__People__Group__10 )
            // InternalGames.g:2924:2: rule__People__Group__9__Impl rule__People__Group__10
            {
            pushFollow(FOLLOW_30);
            rule__People__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__9"


    // $ANTLR start "rule__People__Group__9__Impl"
    // InternalGames.g:2931:1: rule__People__Group__9__Impl : ( ( rule__People__ActiveAssignment_9 ) ) ;
    public final void rule__People__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2935:1: ( ( ( rule__People__ActiveAssignment_9 ) ) )
            // InternalGames.g:2936:1: ( ( rule__People__ActiveAssignment_9 ) )
            {
            // InternalGames.g:2936:1: ( ( rule__People__ActiveAssignment_9 ) )
            // InternalGames.g:2937:2: ( rule__People__ActiveAssignment_9 )
            {
             before(grammarAccess.getPeopleAccess().getActiveAssignment_9()); 
            // InternalGames.g:2938:2: ( rule__People__ActiveAssignment_9 )
            // InternalGames.g:2938:3: rule__People__ActiveAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__People__ActiveAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getActiveAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__9__Impl"


    // $ANTLR start "rule__People__Group__10"
    // InternalGames.g:2946:1: rule__People__Group__10 : rule__People__Group__10__Impl rule__People__Group__11 ;
    public final void rule__People__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2950:1: ( rule__People__Group__10__Impl rule__People__Group__11 )
            // InternalGames.g:2951:2: rule__People__Group__10__Impl rule__People__Group__11
            {
            pushFollow(FOLLOW_30);
            rule__People__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__10"


    // $ANTLR start "rule__People__Group__10__Impl"
    // InternalGames.g:2958:1: rule__People__Group__10__Impl : ( ( rule__People__Group_10__0 )? ) ;
    public final void rule__People__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2962:1: ( ( ( rule__People__Group_10__0 )? ) )
            // InternalGames.g:2963:1: ( ( rule__People__Group_10__0 )? )
            {
            // InternalGames.g:2963:1: ( ( rule__People__Group_10__0 )? )
            // InternalGames.g:2964:2: ( rule__People__Group_10__0 )?
            {
             before(grammarAccess.getPeopleAccess().getGroup_10()); 
            // InternalGames.g:2965:2: ( rule__People__Group_10__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==39) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalGames.g:2965:3: rule__People__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__People__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPeopleAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__10__Impl"


    // $ANTLR start "rule__People__Group__11"
    // InternalGames.g:2973:1: rule__People__Group__11 : rule__People__Group__11__Impl rule__People__Group__12 ;
    public final void rule__People__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2977:1: ( rule__People__Group__11__Impl rule__People__Group__12 )
            // InternalGames.g:2978:2: rule__People__Group__11__Impl rule__People__Group__12
            {
            pushFollow(FOLLOW_22);
            rule__People__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__11"


    // $ANTLR start "rule__People__Group__11__Impl"
    // InternalGames.g:2985:1: rule__People__Group__11__Impl : ( 'isMandatory' ) ;
    public final void rule__People__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:2989:1: ( ( 'isMandatory' ) )
            // InternalGames.g:2990:1: ( 'isMandatory' )
            {
            // InternalGames.g:2990:1: ( 'isMandatory' )
            // InternalGames.g:2991:2: 'isMandatory'
            {
             before(grammarAccess.getPeopleAccess().getIsMandatoryKeyword_11()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getIsMandatoryKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__11__Impl"


    // $ANTLR start "rule__People__Group__12"
    // InternalGames.g:3000:1: rule__People__Group__12 : rule__People__Group__12__Impl rule__People__Group__13 ;
    public final void rule__People__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3004:1: ( rule__People__Group__12__Impl rule__People__Group__13 )
            // InternalGames.g:3005:2: rule__People__Group__12__Impl rule__People__Group__13
            {
            pushFollow(FOLLOW_31);
            rule__People__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__12"


    // $ANTLR start "rule__People__Group__12__Impl"
    // InternalGames.g:3012:1: rule__People__Group__12__Impl : ( ( rule__People__IsMandatoryAssignment_12 ) ) ;
    public final void rule__People__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3016:1: ( ( ( rule__People__IsMandatoryAssignment_12 ) ) )
            // InternalGames.g:3017:1: ( ( rule__People__IsMandatoryAssignment_12 ) )
            {
            // InternalGames.g:3017:1: ( ( rule__People__IsMandatoryAssignment_12 ) )
            // InternalGames.g:3018:2: ( rule__People__IsMandatoryAssignment_12 )
            {
             before(grammarAccess.getPeopleAccess().getIsMandatoryAssignment_12()); 
            // InternalGames.g:3019:2: ( rule__People__IsMandatoryAssignment_12 )
            // InternalGames.g:3019:3: rule__People__IsMandatoryAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__People__IsMandatoryAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getPeopleAccess().getIsMandatoryAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__12__Impl"


    // $ANTLR start "rule__People__Group__13"
    // InternalGames.g:3027:1: rule__People__Group__13 : rule__People__Group__13__Impl rule__People__Group__14 ;
    public final void rule__People__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3031:1: ( rule__People__Group__13__Impl rule__People__Group__14 )
            // InternalGames.g:3032:2: rule__People__Group__13__Impl rule__People__Group__14
            {
            pushFollow(FOLLOW_31);
            rule__People__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__13"


    // $ANTLR start "rule__People__Group__13__Impl"
    // InternalGames.g:3039:1: rule__People__Group__13__Impl : ( ( rule__People__InteractionAssignment_13 )? ) ;
    public final void rule__People__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3043:1: ( ( ( rule__People__InteractionAssignment_13 )? ) )
            // InternalGames.g:3044:1: ( ( rule__People__InteractionAssignment_13 )? )
            {
            // InternalGames.g:3044:1: ( ( rule__People__InteractionAssignment_13 )? )
            // InternalGames.g:3045:2: ( rule__People__InteractionAssignment_13 )?
            {
             before(grammarAccess.getPeopleAccess().getInteractionAssignment_13()); 
            // InternalGames.g:3046:2: ( rule__People__InteractionAssignment_13 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==65) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalGames.g:3046:3: rule__People__InteractionAssignment_13
                    {
                    pushFollow(FOLLOW_2);
                    rule__People__InteractionAssignment_13();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPeopleAccess().getInteractionAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__13__Impl"


    // $ANTLR start "rule__People__Group__14"
    // InternalGames.g:3054:1: rule__People__Group__14 : rule__People__Group__14__Impl ;
    public final void rule__People__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3058:1: ( rule__People__Group__14__Impl )
            // InternalGames.g:3059:2: rule__People__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__People__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__14"


    // $ANTLR start "rule__People__Group__14__Impl"
    // InternalGames.g:3065:1: rule__People__Group__14__Impl : ( '}' ) ;
    public final void rule__People__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3069:1: ( ( '}' ) )
            // InternalGames.g:3070:1: ( '}' )
            {
            // InternalGames.g:3070:1: ( '}' )
            // InternalGames.g:3071:2: '}'
            {
             before(grammarAccess.getPeopleAccess().getRightCurlyBracketKeyword_14()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group__14__Impl"


    // $ANTLR start "rule__People__Group_7__0"
    // InternalGames.g:3081:1: rule__People__Group_7__0 : rule__People__Group_7__0__Impl rule__People__Group_7__1 ;
    public final void rule__People__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3085:1: ( rule__People__Group_7__0__Impl rule__People__Group_7__1 )
            // InternalGames.g:3086:2: rule__People__Group_7__0__Impl rule__People__Group_7__1
            {
            pushFollow(FOLLOW_32);
            rule__People__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_7__0"


    // $ANTLR start "rule__People__Group_7__0__Impl"
    // InternalGames.g:3093:1: rule__People__Group_7__0__Impl : ( 'conditionsVisible' ) ;
    public final void rule__People__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3097:1: ( ( 'conditionsVisible' ) )
            // InternalGames.g:3098:1: ( 'conditionsVisible' )
            {
            // InternalGames.g:3098:1: ( 'conditionsVisible' )
            // InternalGames.g:3099:2: 'conditionsVisible'
            {
             before(grammarAccess.getPeopleAccess().getConditionsVisibleKeyword_7_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getConditionsVisibleKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_7__0__Impl"


    // $ANTLR start "rule__People__Group_7__1"
    // InternalGames.g:3108:1: rule__People__Group_7__1 : rule__People__Group_7__1__Impl ;
    public final void rule__People__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3112:1: ( rule__People__Group_7__1__Impl )
            // InternalGames.g:3113:2: rule__People__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__People__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_7__1"


    // $ANTLR start "rule__People__Group_7__1__Impl"
    // InternalGames.g:3119:1: rule__People__Group_7__1__Impl : ( ( rule__People__ConditionsVisibleAssignment_7_1 )* ) ;
    public final void rule__People__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3123:1: ( ( ( rule__People__ConditionsVisibleAssignment_7_1 )* ) )
            // InternalGames.g:3124:1: ( ( rule__People__ConditionsVisibleAssignment_7_1 )* )
            {
            // InternalGames.g:3124:1: ( ( rule__People__ConditionsVisibleAssignment_7_1 )* )
            // InternalGames.g:3125:2: ( rule__People__ConditionsVisibleAssignment_7_1 )*
            {
             before(grammarAccess.getPeopleAccess().getConditionsVisibleAssignment_7_1()); 
            // InternalGames.g:3126:2: ( rule__People__ConditionsVisibleAssignment_7_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==59) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGames.g:3126:3: rule__People__ConditionsVisibleAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__People__ConditionsVisibleAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getPeopleAccess().getConditionsVisibleAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_7__1__Impl"


    // $ANTLR start "rule__People__Group_10__0"
    // InternalGames.g:3135:1: rule__People__Group_10__0 : rule__People__Group_10__0__Impl rule__People__Group_10__1 ;
    public final void rule__People__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3139:1: ( rule__People__Group_10__0__Impl rule__People__Group_10__1 )
            // InternalGames.g:3140:2: rule__People__Group_10__0__Impl rule__People__Group_10__1
            {
            pushFollow(FOLLOW_32);
            rule__People__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__People__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_10__0"


    // $ANTLR start "rule__People__Group_10__0__Impl"
    // InternalGames.g:3147:1: rule__People__Group_10__0__Impl : ( 'conditionsActive' ) ;
    public final void rule__People__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3151:1: ( ( 'conditionsActive' ) )
            // InternalGames.g:3152:1: ( 'conditionsActive' )
            {
            // InternalGames.g:3152:1: ( 'conditionsActive' )
            // InternalGames.g:3153:2: 'conditionsActive'
            {
             before(grammarAccess.getPeopleAccess().getConditionsActiveKeyword_10_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getConditionsActiveKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_10__0__Impl"


    // $ANTLR start "rule__People__Group_10__1"
    // InternalGames.g:3162:1: rule__People__Group_10__1 : rule__People__Group_10__1__Impl ;
    public final void rule__People__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3166:1: ( rule__People__Group_10__1__Impl )
            // InternalGames.g:3167:2: rule__People__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__People__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_10__1"


    // $ANTLR start "rule__People__Group_10__1__Impl"
    // InternalGames.g:3173:1: rule__People__Group_10__1__Impl : ( ( rule__People__ConditionsActiveAssignment_10_1 )* ) ;
    public final void rule__People__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3177:1: ( ( ( rule__People__ConditionsActiveAssignment_10_1 )* ) )
            // InternalGames.g:3178:1: ( ( rule__People__ConditionsActiveAssignment_10_1 )* )
            {
            // InternalGames.g:3178:1: ( ( rule__People__ConditionsActiveAssignment_10_1 )* )
            // InternalGames.g:3179:2: ( rule__People__ConditionsActiveAssignment_10_1 )*
            {
             before(grammarAccess.getPeopleAccess().getConditionsActiveAssignment_10_1()); 
            // InternalGames.g:3180:2: ( rule__People__ConditionsActiveAssignment_10_1 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==59) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGames.g:3180:3: rule__People__ConditionsActiveAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__People__ConditionsActiveAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getPeopleAccess().getConditionsActiveAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__Group_10__1__Impl"


    // $ANTLR start "rule__Path__Group__0"
    // InternalGames.g:3189:1: rule__Path__Group__0 : rule__Path__Group__0__Impl rule__Path__Group__1 ;
    public final void rule__Path__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3193:1: ( rule__Path__Group__0__Impl rule__Path__Group__1 )
            // InternalGames.g:3194:2: rule__Path__Group__0__Impl rule__Path__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Path__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__0"


    // $ANTLR start "rule__Path__Group__0__Impl"
    // InternalGames.g:3201:1: rule__Path__Group__0__Impl : ( 'path' ) ;
    public final void rule__Path__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3205:1: ( ( 'path' ) )
            // InternalGames.g:3206:1: ( 'path' )
            {
            // InternalGames.g:3206:1: ( 'path' )
            // InternalGames.g:3207:2: 'path'
            {
             before(grammarAccess.getPathAccess().getPathKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getPathKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__0__Impl"


    // $ANTLR start "rule__Path__Group__1"
    // InternalGames.g:3216:1: rule__Path__Group__1 : rule__Path__Group__1__Impl rule__Path__Group__2 ;
    public final void rule__Path__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3220:1: ( rule__Path__Group__1__Impl rule__Path__Group__2 )
            // InternalGames.g:3221:2: rule__Path__Group__1__Impl rule__Path__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Path__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__1"


    // $ANTLR start "rule__Path__Group__1__Impl"
    // InternalGames.g:3228:1: rule__Path__Group__1__Impl : ( ( rule__Path__NameAssignment_1 ) ) ;
    public final void rule__Path__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3232:1: ( ( ( rule__Path__NameAssignment_1 ) ) )
            // InternalGames.g:3233:1: ( ( rule__Path__NameAssignment_1 ) )
            {
            // InternalGames.g:3233:1: ( ( rule__Path__NameAssignment_1 ) )
            // InternalGames.g:3234:2: ( rule__Path__NameAssignment_1 )
            {
             before(grammarAccess.getPathAccess().getNameAssignment_1()); 
            // InternalGames.g:3235:2: ( rule__Path__NameAssignment_1 )
            // InternalGames.g:3235:3: rule__Path__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Path__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__1__Impl"


    // $ANTLR start "rule__Path__Group__2"
    // InternalGames.g:3243:1: rule__Path__Group__2 : rule__Path__Group__2__Impl rule__Path__Group__3 ;
    public final void rule__Path__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3247:1: ( rule__Path__Group__2__Impl rule__Path__Group__3 )
            // InternalGames.g:3248:2: rule__Path__Group__2__Impl rule__Path__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Path__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__2"


    // $ANTLR start "rule__Path__Group__2__Impl"
    // InternalGames.g:3255:1: rule__Path__Group__2__Impl : ( '{' ) ;
    public final void rule__Path__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3259:1: ( ( '{' ) )
            // InternalGames.g:3260:1: ( '{' )
            {
            // InternalGames.g:3260:1: ( '{' )
            // InternalGames.g:3261:2: '{'
            {
             before(grammarAccess.getPathAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__2__Impl"


    // $ANTLR start "rule__Path__Group__3"
    // InternalGames.g:3270:1: rule__Path__Group__3 : rule__Path__Group__3__Impl rule__Path__Group__4 ;
    public final void rule__Path__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3274:1: ( rule__Path__Group__3__Impl rule__Path__Group__4 )
            // InternalGames.g:3275:2: rule__Path__Group__3__Impl rule__Path__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__Path__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__3"


    // $ANTLR start "rule__Path__Group__3__Impl"
    // InternalGames.g:3282:1: rule__Path__Group__3__Impl : ( 'description' ) ;
    public final void rule__Path__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3286:1: ( ( 'description' ) )
            // InternalGames.g:3287:1: ( 'description' )
            {
            // InternalGames.g:3287:1: ( 'description' )
            // InternalGames.g:3288:2: 'description'
            {
             before(grammarAccess.getPathAccess().getDescriptionKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getDescriptionKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__3__Impl"


    // $ANTLR start "rule__Path__Group__4"
    // InternalGames.g:3297:1: rule__Path__Group__4 : rule__Path__Group__4__Impl rule__Path__Group__5 ;
    public final void rule__Path__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3301:1: ( rule__Path__Group__4__Impl rule__Path__Group__5 )
            // InternalGames.g:3302:2: rule__Path__Group__4__Impl rule__Path__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__Path__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__4"


    // $ANTLR start "rule__Path__Group__4__Impl"
    // InternalGames.g:3309:1: rule__Path__Group__4__Impl : ( ( rule__Path__DescriptionAssignment_4 ) ) ;
    public final void rule__Path__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3313:1: ( ( ( rule__Path__DescriptionAssignment_4 ) ) )
            // InternalGames.g:3314:1: ( ( rule__Path__DescriptionAssignment_4 ) )
            {
            // InternalGames.g:3314:1: ( ( rule__Path__DescriptionAssignment_4 ) )
            // InternalGames.g:3315:2: ( rule__Path__DescriptionAssignment_4 )
            {
             before(grammarAccess.getPathAccess().getDescriptionAssignment_4()); 
            // InternalGames.g:3316:2: ( rule__Path__DescriptionAssignment_4 )
            // InternalGames.g:3316:3: rule__Path__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Path__DescriptionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getDescriptionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__4__Impl"


    // $ANTLR start "rule__Path__Group__5"
    // InternalGames.g:3324:1: rule__Path__Group__5 : rule__Path__Group__5__Impl rule__Path__Group__6 ;
    public final void rule__Path__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3328:1: ( rule__Path__Group__5__Impl rule__Path__Group__6 )
            // InternalGames.g:3329:2: rule__Path__Group__5__Impl rule__Path__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__Path__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__5"


    // $ANTLR start "rule__Path__Group__5__Impl"
    // InternalGames.g:3336:1: rule__Path__Group__5__Impl : ( 'visible' ) ;
    public final void rule__Path__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3340:1: ( ( 'visible' ) )
            // InternalGames.g:3341:1: ( 'visible' )
            {
            // InternalGames.g:3341:1: ( 'visible' )
            // InternalGames.g:3342:2: 'visible'
            {
             before(grammarAccess.getPathAccess().getVisibleKeyword_5()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getVisibleKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__5__Impl"


    // $ANTLR start "rule__Path__Group__6"
    // InternalGames.g:3351:1: rule__Path__Group__6 : rule__Path__Group__6__Impl rule__Path__Group__7 ;
    public final void rule__Path__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3355:1: ( rule__Path__Group__6__Impl rule__Path__Group__7 )
            // InternalGames.g:3356:2: rule__Path__Group__6__Impl rule__Path__Group__7
            {
            pushFollow(FOLLOW_34);
            rule__Path__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__6"


    // $ANTLR start "rule__Path__Group__6__Impl"
    // InternalGames.g:3363:1: rule__Path__Group__6__Impl : ( ( rule__Path__VisibleAssignment_6 ) ) ;
    public final void rule__Path__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3367:1: ( ( ( rule__Path__VisibleAssignment_6 ) ) )
            // InternalGames.g:3368:1: ( ( rule__Path__VisibleAssignment_6 ) )
            {
            // InternalGames.g:3368:1: ( ( rule__Path__VisibleAssignment_6 ) )
            // InternalGames.g:3369:2: ( rule__Path__VisibleAssignment_6 )
            {
             before(grammarAccess.getPathAccess().getVisibleAssignment_6()); 
            // InternalGames.g:3370:2: ( rule__Path__VisibleAssignment_6 )
            // InternalGames.g:3370:3: rule__Path__VisibleAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Path__VisibleAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getVisibleAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__6__Impl"


    // $ANTLR start "rule__Path__Group__7"
    // InternalGames.g:3378:1: rule__Path__Group__7 : rule__Path__Group__7__Impl rule__Path__Group__8 ;
    public final void rule__Path__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3382:1: ( rule__Path__Group__7__Impl rule__Path__Group__8 )
            // InternalGames.g:3383:2: rule__Path__Group__7__Impl rule__Path__Group__8
            {
            pushFollow(FOLLOW_34);
            rule__Path__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__7"


    // $ANTLR start "rule__Path__Group__7__Impl"
    // InternalGames.g:3390:1: rule__Path__Group__7__Impl : ( ( rule__Path__Group_7__0 )? ) ;
    public final void rule__Path__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3394:1: ( ( ( rule__Path__Group_7__0 )? ) )
            // InternalGames.g:3395:1: ( ( rule__Path__Group_7__0 )? )
            {
            // InternalGames.g:3395:1: ( ( rule__Path__Group_7__0 )? )
            // InternalGames.g:3396:2: ( rule__Path__Group_7__0 )?
            {
             before(grammarAccess.getPathAccess().getGroup_7()); 
            // InternalGames.g:3397:2: ( rule__Path__Group_7__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==38) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalGames.g:3397:3: rule__Path__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Path__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPathAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__7__Impl"


    // $ANTLR start "rule__Path__Group__8"
    // InternalGames.g:3405:1: rule__Path__Group__8 : rule__Path__Group__8__Impl rule__Path__Group__9 ;
    public final void rule__Path__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3409:1: ( rule__Path__Group__8__Impl rule__Path__Group__9 )
            // InternalGames.g:3410:2: rule__Path__Group__8__Impl rule__Path__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__Path__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__8"


    // $ANTLR start "rule__Path__Group__8__Impl"
    // InternalGames.g:3417:1: rule__Path__Group__8__Impl : ( 'endPlace' ) ;
    public final void rule__Path__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3421:1: ( ( 'endPlace' ) )
            // InternalGames.g:3422:1: ( 'endPlace' )
            {
            // InternalGames.g:3422:1: ( 'endPlace' )
            // InternalGames.g:3423:2: 'endPlace'
            {
             before(grammarAccess.getPathAccess().getEndPlaceKeyword_8()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getEndPlaceKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__8__Impl"


    // $ANTLR start "rule__Path__Group__9"
    // InternalGames.g:3432:1: rule__Path__Group__9 : rule__Path__Group__9__Impl rule__Path__Group__10 ;
    public final void rule__Path__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3436:1: ( rule__Path__Group__9__Impl rule__Path__Group__10 )
            // InternalGames.g:3437:2: rule__Path__Group__9__Impl rule__Path__Group__10
            {
            pushFollow(FOLLOW_35);
            rule__Path__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__9"


    // $ANTLR start "rule__Path__Group__9__Impl"
    // InternalGames.g:3444:1: rule__Path__Group__9__Impl : ( ( rule__Path__EndPlaceAssignment_9 ) ) ;
    public final void rule__Path__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3448:1: ( ( ( rule__Path__EndPlaceAssignment_9 ) ) )
            // InternalGames.g:3449:1: ( ( rule__Path__EndPlaceAssignment_9 ) )
            {
            // InternalGames.g:3449:1: ( ( rule__Path__EndPlaceAssignment_9 ) )
            // InternalGames.g:3450:2: ( rule__Path__EndPlaceAssignment_9 )
            {
             before(grammarAccess.getPathAccess().getEndPlaceAssignment_9()); 
            // InternalGames.g:3451:2: ( rule__Path__EndPlaceAssignment_9 )
            // InternalGames.g:3451:3: rule__Path__EndPlaceAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Path__EndPlaceAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getEndPlaceAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__9__Impl"


    // $ANTLR start "rule__Path__Group__10"
    // InternalGames.g:3459:1: rule__Path__Group__10 : rule__Path__Group__10__Impl rule__Path__Group__11 ;
    public final void rule__Path__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3463:1: ( rule__Path__Group__10__Impl rule__Path__Group__11 )
            // InternalGames.g:3464:2: rule__Path__Group__10__Impl rule__Path__Group__11
            {
            pushFollow(FOLLOW_22);
            rule__Path__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__10"


    // $ANTLR start "rule__Path__Group__10__Impl"
    // InternalGames.g:3471:1: rule__Path__Group__10__Impl : ( 'isOpen' ) ;
    public final void rule__Path__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3475:1: ( ( 'isOpen' ) )
            // InternalGames.g:3476:1: ( 'isOpen' )
            {
            // InternalGames.g:3476:1: ( 'isOpen' )
            // InternalGames.g:3477:2: 'isOpen'
            {
             before(grammarAccess.getPathAccess().getIsOpenKeyword_10()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getIsOpenKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__10__Impl"


    // $ANTLR start "rule__Path__Group__11"
    // InternalGames.g:3486:1: rule__Path__Group__11 : rule__Path__Group__11__Impl rule__Path__Group__12 ;
    public final void rule__Path__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3490:1: ( rule__Path__Group__11__Impl rule__Path__Group__12 )
            // InternalGames.g:3491:2: rule__Path__Group__11__Impl rule__Path__Group__12
            {
            pushFollow(FOLLOW_36);
            rule__Path__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__11"


    // $ANTLR start "rule__Path__Group__11__Impl"
    // InternalGames.g:3498:1: rule__Path__Group__11__Impl : ( ( rule__Path__IsOpenAssignment_11 ) ) ;
    public final void rule__Path__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3502:1: ( ( ( rule__Path__IsOpenAssignment_11 ) ) )
            // InternalGames.g:3503:1: ( ( rule__Path__IsOpenAssignment_11 ) )
            {
            // InternalGames.g:3503:1: ( ( rule__Path__IsOpenAssignment_11 ) )
            // InternalGames.g:3504:2: ( rule__Path__IsOpenAssignment_11 )
            {
             before(grammarAccess.getPathAccess().getIsOpenAssignment_11()); 
            // InternalGames.g:3505:2: ( rule__Path__IsOpenAssignment_11 )
            // InternalGames.g:3505:3: rule__Path__IsOpenAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Path__IsOpenAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getIsOpenAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__11__Impl"


    // $ANTLR start "rule__Path__Group__12"
    // InternalGames.g:3513:1: rule__Path__Group__12 : rule__Path__Group__12__Impl rule__Path__Group__13 ;
    public final void rule__Path__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3517:1: ( rule__Path__Group__12__Impl rule__Path__Group__13 )
            // InternalGames.g:3518:2: rule__Path__Group__12__Impl rule__Path__Group__13
            {
            pushFollow(FOLLOW_36);
            rule__Path__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__12"


    // $ANTLR start "rule__Path__Group__12__Impl"
    // InternalGames.g:3525:1: rule__Path__Group__12__Impl : ( ( rule__Path__Group_12__0 )? ) ;
    public final void rule__Path__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3529:1: ( ( ( rule__Path__Group_12__0 )? ) )
            // InternalGames.g:3530:1: ( ( rule__Path__Group_12__0 )? )
            {
            // InternalGames.g:3530:1: ( ( rule__Path__Group_12__0 )? )
            // InternalGames.g:3531:2: ( rule__Path__Group_12__0 )?
            {
             before(grammarAccess.getPathAccess().getGroup_12()); 
            // InternalGames.g:3532:2: ( rule__Path__Group_12__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==41) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalGames.g:3532:3: rule__Path__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Path__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPathAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__12__Impl"


    // $ANTLR start "rule__Path__Group__13"
    // InternalGames.g:3540:1: rule__Path__Group__13 : rule__Path__Group__13__Impl rule__Path__Group__14 ;
    public final void rule__Path__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3544:1: ( rule__Path__Group__13__Impl rule__Path__Group__14 )
            // InternalGames.g:3545:2: rule__Path__Group__13__Impl rule__Path__Group__14
            {
            pushFollow(FOLLOW_22);
            rule__Path__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__13"


    // $ANTLR start "rule__Path__Group__13__Impl"
    // InternalGames.g:3552:1: rule__Path__Group__13__Impl : ( 'isMandatory' ) ;
    public final void rule__Path__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3556:1: ( ( 'isMandatory' ) )
            // InternalGames.g:3557:1: ( 'isMandatory' )
            {
            // InternalGames.g:3557:1: ( 'isMandatory' )
            // InternalGames.g:3558:2: 'isMandatory'
            {
             before(grammarAccess.getPathAccess().getIsMandatoryKeyword_13()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getIsMandatoryKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__13__Impl"


    // $ANTLR start "rule__Path__Group__14"
    // InternalGames.g:3567:1: rule__Path__Group__14 : rule__Path__Group__14__Impl rule__Path__Group__15 ;
    public final void rule__Path__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3571:1: ( rule__Path__Group__14__Impl rule__Path__Group__15 )
            // InternalGames.g:3572:2: rule__Path__Group__14__Impl rule__Path__Group__15
            {
            pushFollow(FOLLOW_37);
            rule__Path__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__14"


    // $ANTLR start "rule__Path__Group__14__Impl"
    // InternalGames.g:3579:1: rule__Path__Group__14__Impl : ( ( rule__Path__IsMandatoryAssignment_14 ) ) ;
    public final void rule__Path__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3583:1: ( ( ( rule__Path__IsMandatoryAssignment_14 ) ) )
            // InternalGames.g:3584:1: ( ( rule__Path__IsMandatoryAssignment_14 ) )
            {
            // InternalGames.g:3584:1: ( ( rule__Path__IsMandatoryAssignment_14 ) )
            // InternalGames.g:3585:2: ( rule__Path__IsMandatoryAssignment_14 )
            {
             before(grammarAccess.getPathAccess().getIsMandatoryAssignment_14()); 
            // InternalGames.g:3586:2: ( rule__Path__IsMandatoryAssignment_14 )
            // InternalGames.g:3586:3: rule__Path__IsMandatoryAssignment_14
            {
            pushFollow(FOLLOW_2);
            rule__Path__IsMandatoryAssignment_14();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getIsMandatoryAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__14__Impl"


    // $ANTLR start "rule__Path__Group__15"
    // InternalGames.g:3594:1: rule__Path__Group__15 : rule__Path__Group__15__Impl rule__Path__Group__16 ;
    public final void rule__Path__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3598:1: ( rule__Path__Group__15__Impl rule__Path__Group__16 )
            // InternalGames.g:3599:2: rule__Path__Group__15__Impl rule__Path__Group__16
            {
            pushFollow(FOLLOW_37);
            rule__Path__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__15"


    // $ANTLR start "rule__Path__Group__15__Impl"
    // InternalGames.g:3606:1: rule__Path__Group__15__Impl : ( ( rule__Path__Group_15__0 )? ) ;
    public final void rule__Path__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3610:1: ( ( ( rule__Path__Group_15__0 )? ) )
            // InternalGames.g:3611:1: ( ( rule__Path__Group_15__0 )? )
            {
            // InternalGames.g:3611:1: ( ( rule__Path__Group_15__0 )? )
            // InternalGames.g:3612:2: ( rule__Path__Group_15__0 )?
            {
             before(grammarAccess.getPathAccess().getGroup_15()); 
            // InternalGames.g:3613:2: ( rule__Path__Group_15__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==42) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalGames.g:3613:3: rule__Path__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Path__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPathAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__15__Impl"


    // $ANTLR start "rule__Path__Group__16"
    // InternalGames.g:3621:1: rule__Path__Group__16 : rule__Path__Group__16__Impl rule__Path__Group__17 ;
    public final void rule__Path__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3625:1: ( rule__Path__Group__16__Impl rule__Path__Group__17 )
            // InternalGames.g:3626:2: rule__Path__Group__16__Impl rule__Path__Group__17
            {
            pushFollow(FOLLOW_37);
            rule__Path__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__16"


    // $ANTLR start "rule__Path__Group__16__Impl"
    // InternalGames.g:3633:1: rule__Path__Group__16__Impl : ( ( rule__Path__Group_16__0 )? ) ;
    public final void rule__Path__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3637:1: ( ( ( rule__Path__Group_16__0 )? ) )
            // InternalGames.g:3638:1: ( ( rule__Path__Group_16__0 )? )
            {
            // InternalGames.g:3638:1: ( ( rule__Path__Group_16__0 )? )
            // InternalGames.g:3639:2: ( rule__Path__Group_16__0 )?
            {
             before(grammarAccess.getPathAccess().getGroup_16()); 
            // InternalGames.g:3640:2: ( rule__Path__Group_16__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalGames.g:3640:3: rule__Path__Group_16__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Path__Group_16__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPathAccess().getGroup_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__16__Impl"


    // $ANTLR start "rule__Path__Group__17"
    // InternalGames.g:3648:1: rule__Path__Group__17 : rule__Path__Group__17__Impl rule__Path__Group__18 ;
    public final void rule__Path__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3652:1: ( rule__Path__Group__17__Impl rule__Path__Group__18 )
            // InternalGames.g:3653:2: rule__Path__Group__17__Impl rule__Path__Group__18
            {
            pushFollow(FOLLOW_37);
            rule__Path__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__17"


    // $ANTLR start "rule__Path__Group__17__Impl"
    // InternalGames.g:3660:1: rule__Path__Group__17__Impl : ( ( rule__Path__Group_17__0 )? ) ;
    public final void rule__Path__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3664:1: ( ( ( rule__Path__Group_17__0 )? ) )
            // InternalGames.g:3665:1: ( ( rule__Path__Group_17__0 )? )
            {
            // InternalGames.g:3665:1: ( ( rule__Path__Group_17__0 )? )
            // InternalGames.g:3666:2: ( rule__Path__Group_17__0 )?
            {
             before(grammarAccess.getPathAccess().getGroup_17()); 
            // InternalGames.g:3667:2: ( rule__Path__Group_17__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGames.g:3667:3: rule__Path__Group_17__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Path__Group_17__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPathAccess().getGroup_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__17__Impl"


    // $ANTLR start "rule__Path__Group__18"
    // InternalGames.g:3675:1: rule__Path__Group__18 : rule__Path__Group__18__Impl ;
    public final void rule__Path__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3679:1: ( rule__Path__Group__18__Impl )
            // InternalGames.g:3680:2: rule__Path__Group__18__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group__18__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__18"


    // $ANTLR start "rule__Path__Group__18__Impl"
    // InternalGames.g:3686:1: rule__Path__Group__18__Impl : ( '}' ) ;
    public final void rule__Path__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3690:1: ( ( '}' ) )
            // InternalGames.g:3691:1: ( '}' )
            {
            // InternalGames.g:3691:1: ( '}' )
            // InternalGames.g:3692:2: '}'
            {
             before(grammarAccess.getPathAccess().getRightCurlyBracketKeyword_18()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getRightCurlyBracketKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__18__Impl"


    // $ANTLR start "rule__Path__Group_7__0"
    // InternalGames.g:3702:1: rule__Path__Group_7__0 : rule__Path__Group_7__0__Impl rule__Path__Group_7__1 ;
    public final void rule__Path__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3706:1: ( rule__Path__Group_7__0__Impl rule__Path__Group_7__1 )
            // InternalGames.g:3707:2: rule__Path__Group_7__0__Impl rule__Path__Group_7__1
            {
            pushFollow(FOLLOW_32);
            rule__Path__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_7__0"


    // $ANTLR start "rule__Path__Group_7__0__Impl"
    // InternalGames.g:3714:1: rule__Path__Group_7__0__Impl : ( 'conditionsVisible' ) ;
    public final void rule__Path__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3718:1: ( ( 'conditionsVisible' ) )
            // InternalGames.g:3719:1: ( 'conditionsVisible' )
            {
            // InternalGames.g:3719:1: ( 'conditionsVisible' )
            // InternalGames.g:3720:2: 'conditionsVisible'
            {
             before(grammarAccess.getPathAccess().getConditionsVisibleKeyword_7_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getConditionsVisibleKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_7__0__Impl"


    // $ANTLR start "rule__Path__Group_7__1"
    // InternalGames.g:3729:1: rule__Path__Group_7__1 : rule__Path__Group_7__1__Impl ;
    public final void rule__Path__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3733:1: ( rule__Path__Group_7__1__Impl )
            // InternalGames.g:3734:2: rule__Path__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_7__1"


    // $ANTLR start "rule__Path__Group_7__1__Impl"
    // InternalGames.g:3740:1: rule__Path__Group_7__1__Impl : ( ( rule__Path__ConditionVisibleAssignment_7_1 )* ) ;
    public final void rule__Path__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3744:1: ( ( ( rule__Path__ConditionVisibleAssignment_7_1 )* ) )
            // InternalGames.g:3745:1: ( ( rule__Path__ConditionVisibleAssignment_7_1 )* )
            {
            // InternalGames.g:3745:1: ( ( rule__Path__ConditionVisibleAssignment_7_1 )* )
            // InternalGames.g:3746:2: ( rule__Path__ConditionVisibleAssignment_7_1 )*
            {
             before(grammarAccess.getPathAccess().getConditionVisibleAssignment_7_1()); 
            // InternalGames.g:3747:2: ( rule__Path__ConditionVisibleAssignment_7_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==59) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalGames.g:3747:3: rule__Path__ConditionVisibleAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Path__ConditionVisibleAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getConditionVisibleAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_7__1__Impl"


    // $ANTLR start "rule__Path__Group_12__0"
    // InternalGames.g:3756:1: rule__Path__Group_12__0 : rule__Path__Group_12__0__Impl rule__Path__Group_12__1 ;
    public final void rule__Path__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3760:1: ( rule__Path__Group_12__0__Impl rule__Path__Group_12__1 )
            // InternalGames.g:3761:2: rule__Path__Group_12__0__Impl rule__Path__Group_12__1
            {
            pushFollow(FOLLOW_32);
            rule__Path__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_12__0"


    // $ANTLR start "rule__Path__Group_12__0__Impl"
    // InternalGames.g:3768:1: rule__Path__Group_12__0__Impl : ( 'conditionsOpen' ) ;
    public final void rule__Path__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3772:1: ( ( 'conditionsOpen' ) )
            // InternalGames.g:3773:1: ( 'conditionsOpen' )
            {
            // InternalGames.g:3773:1: ( 'conditionsOpen' )
            // InternalGames.g:3774:2: 'conditionsOpen'
            {
             before(grammarAccess.getPathAccess().getConditionsOpenKeyword_12_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getConditionsOpenKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_12__0__Impl"


    // $ANTLR start "rule__Path__Group_12__1"
    // InternalGames.g:3783:1: rule__Path__Group_12__1 : rule__Path__Group_12__1__Impl ;
    public final void rule__Path__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3787:1: ( rule__Path__Group_12__1__Impl )
            // InternalGames.g:3788:2: rule__Path__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_12__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_12__1"


    // $ANTLR start "rule__Path__Group_12__1__Impl"
    // InternalGames.g:3794:1: rule__Path__Group_12__1__Impl : ( ( rule__Path__ConditionsOpeningAssignment_12_1 )* ) ;
    public final void rule__Path__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3798:1: ( ( ( rule__Path__ConditionsOpeningAssignment_12_1 )* ) )
            // InternalGames.g:3799:1: ( ( rule__Path__ConditionsOpeningAssignment_12_1 )* )
            {
            // InternalGames.g:3799:1: ( ( rule__Path__ConditionsOpeningAssignment_12_1 )* )
            // InternalGames.g:3800:2: ( rule__Path__ConditionsOpeningAssignment_12_1 )*
            {
             before(grammarAccess.getPathAccess().getConditionsOpeningAssignment_12_1()); 
            // InternalGames.g:3801:2: ( rule__Path__ConditionsOpeningAssignment_12_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==59) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalGames.g:3801:3: rule__Path__ConditionsOpeningAssignment_12_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Path__ConditionsOpeningAssignment_12_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getConditionsOpeningAssignment_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_12__1__Impl"


    // $ANTLR start "rule__Path__Group_15__0"
    // InternalGames.g:3810:1: rule__Path__Group_15__0 : rule__Path__Group_15__0__Impl rule__Path__Group_15__1 ;
    public final void rule__Path__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3814:1: ( rule__Path__Group_15__0__Impl rule__Path__Group_15__1 )
            // InternalGames.g:3815:2: rule__Path__Group_15__0__Impl rule__Path__Group_15__1
            {
            pushFollow(FOLLOW_3);
            rule__Path__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_15__0"


    // $ANTLR start "rule__Path__Group_15__0__Impl"
    // InternalGames.g:3822:1: rule__Path__Group_15__0__Impl : ( 'knowledgesGiven' ) ;
    public final void rule__Path__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3826:1: ( ( 'knowledgesGiven' ) )
            // InternalGames.g:3827:1: ( 'knowledgesGiven' )
            {
            // InternalGames.g:3827:1: ( 'knowledgesGiven' )
            // InternalGames.g:3828:2: 'knowledgesGiven'
            {
             before(grammarAccess.getPathAccess().getKnowledgesGivenKeyword_15_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getKnowledgesGivenKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_15__0__Impl"


    // $ANTLR start "rule__Path__Group_15__1"
    // InternalGames.g:3837:1: rule__Path__Group_15__1 : rule__Path__Group_15__1__Impl ;
    public final void rule__Path__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3841:1: ( rule__Path__Group_15__1__Impl )
            // InternalGames.g:3842:2: rule__Path__Group_15__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_15__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_15__1"


    // $ANTLR start "rule__Path__Group_15__1__Impl"
    // InternalGames.g:3848:1: rule__Path__Group_15__1__Impl : ( ( rule__Path__KnowledgeGivenAssignment_15_1 )* ) ;
    public final void rule__Path__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3852:1: ( ( ( rule__Path__KnowledgeGivenAssignment_15_1 )* ) )
            // InternalGames.g:3853:1: ( ( rule__Path__KnowledgeGivenAssignment_15_1 )* )
            {
            // InternalGames.g:3853:1: ( ( rule__Path__KnowledgeGivenAssignment_15_1 )* )
            // InternalGames.g:3854:2: ( rule__Path__KnowledgeGivenAssignment_15_1 )*
            {
             before(grammarAccess.getPathAccess().getKnowledgeGivenAssignment_15_1()); 
            // InternalGames.g:3855:2: ( rule__Path__KnowledgeGivenAssignment_15_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalGames.g:3855:3: rule__Path__KnowledgeGivenAssignment_15_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Path__KnowledgeGivenAssignment_15_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getKnowledgeGivenAssignment_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_15__1__Impl"


    // $ANTLR start "rule__Path__Group_16__0"
    // InternalGames.g:3864:1: rule__Path__Group_16__0 : rule__Path__Group_16__0__Impl rule__Path__Group_16__1 ;
    public final void rule__Path__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3868:1: ( rule__Path__Group_16__0__Impl rule__Path__Group_16__1 )
            // InternalGames.g:3869:2: rule__Path__Group_16__0__Impl rule__Path__Group_16__1
            {
            pushFollow(FOLLOW_3);
            rule__Path__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_16__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_16__0"


    // $ANTLR start "rule__Path__Group_16__0__Impl"
    // InternalGames.g:3876:1: rule__Path__Group_16__0__Impl : ( 'itemsGiven' ) ;
    public final void rule__Path__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3880:1: ( ( 'itemsGiven' ) )
            // InternalGames.g:3881:1: ( 'itemsGiven' )
            {
            // InternalGames.g:3881:1: ( 'itemsGiven' )
            // InternalGames.g:3882:2: 'itemsGiven'
            {
             before(grammarAccess.getPathAccess().getItemsGivenKeyword_16_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getItemsGivenKeyword_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_16__0__Impl"


    // $ANTLR start "rule__Path__Group_16__1"
    // InternalGames.g:3891:1: rule__Path__Group_16__1 : rule__Path__Group_16__1__Impl ;
    public final void rule__Path__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3895:1: ( rule__Path__Group_16__1__Impl )
            // InternalGames.g:3896:2: rule__Path__Group_16__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_16__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_16__1"


    // $ANTLR start "rule__Path__Group_16__1__Impl"
    // InternalGames.g:3902:1: rule__Path__Group_16__1__Impl : ( ( rule__Path__ItemsGivenAssignment_16_1 )* ) ;
    public final void rule__Path__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3906:1: ( ( ( rule__Path__ItemsGivenAssignment_16_1 )* ) )
            // InternalGames.g:3907:1: ( ( rule__Path__ItemsGivenAssignment_16_1 )* )
            {
            // InternalGames.g:3907:1: ( ( rule__Path__ItemsGivenAssignment_16_1 )* )
            // InternalGames.g:3908:2: ( rule__Path__ItemsGivenAssignment_16_1 )*
            {
             before(grammarAccess.getPathAccess().getItemsGivenAssignment_16_1()); 
            // InternalGames.g:3909:2: ( rule__Path__ItemsGivenAssignment_16_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalGames.g:3909:3: rule__Path__ItemsGivenAssignment_16_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Path__ItemsGivenAssignment_16_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getItemsGivenAssignment_16_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_16__1__Impl"


    // $ANTLR start "rule__Path__Group_17__0"
    // InternalGames.g:3918:1: rule__Path__Group_17__0 : rule__Path__Group_17__0__Impl rule__Path__Group_17__1 ;
    public final void rule__Path__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3922:1: ( rule__Path__Group_17__0__Impl rule__Path__Group_17__1 )
            // InternalGames.g:3923:2: rule__Path__Group_17__0__Impl rule__Path__Group_17__1
            {
            pushFollow(FOLLOW_3);
            rule__Path__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_17__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_17__0"


    // $ANTLR start "rule__Path__Group_17__0__Impl"
    // InternalGames.g:3930:1: rule__Path__Group_17__0__Impl : ( 'itemsConsumed' ) ;
    public final void rule__Path__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3934:1: ( ( 'itemsConsumed' ) )
            // InternalGames.g:3935:1: ( 'itemsConsumed' )
            {
            // InternalGames.g:3935:1: ( 'itemsConsumed' )
            // InternalGames.g:3936:2: 'itemsConsumed'
            {
             before(grammarAccess.getPathAccess().getItemsConsumedKeyword_17_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getItemsConsumedKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_17__0__Impl"


    // $ANTLR start "rule__Path__Group_17__1"
    // InternalGames.g:3945:1: rule__Path__Group_17__1 : rule__Path__Group_17__1__Impl ;
    public final void rule__Path__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3949:1: ( rule__Path__Group_17__1__Impl )
            // InternalGames.g:3950:2: rule__Path__Group_17__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_17__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_17__1"


    // $ANTLR start "rule__Path__Group_17__1__Impl"
    // InternalGames.g:3956:1: rule__Path__Group_17__1__Impl : ( ( rule__Path__ItemsConsumedAssignment_17_1 )* ) ;
    public final void rule__Path__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3960:1: ( ( ( rule__Path__ItemsConsumedAssignment_17_1 )* ) )
            // InternalGames.g:3961:1: ( ( rule__Path__ItemsConsumedAssignment_17_1 )* )
            {
            // InternalGames.g:3961:1: ( ( rule__Path__ItemsConsumedAssignment_17_1 )* )
            // InternalGames.g:3962:2: ( rule__Path__ItemsConsumedAssignment_17_1 )*
            {
             before(grammarAccess.getPathAccess().getItemsConsumedAssignment_17_1()); 
            // InternalGames.g:3963:2: ( rule__Path__ItemsConsumedAssignment_17_1 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalGames.g:3963:3: rule__Path__ItemsConsumedAssignment_17_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Path__ItemsConsumedAssignment_17_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getItemsConsumedAssignment_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_17__1__Impl"


    // $ANTLR start "rule__Item__Group__0"
    // InternalGames.g:3972:1: rule__Item__Group__0 : rule__Item__Group__0__Impl rule__Item__Group__1 ;
    public final void rule__Item__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3976:1: ( rule__Item__Group__0__Impl rule__Item__Group__1 )
            // InternalGames.g:3977:2: rule__Item__Group__0__Impl rule__Item__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Item__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__0"


    // $ANTLR start "rule__Item__Group__0__Impl"
    // InternalGames.g:3984:1: rule__Item__Group__0__Impl : ( 'item' ) ;
    public final void rule__Item__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:3988:1: ( ( 'item' ) )
            // InternalGames.g:3989:1: ( 'item' )
            {
            // InternalGames.g:3989:1: ( 'item' )
            // InternalGames.g:3990:2: 'item'
            {
             before(grammarAccess.getItemAccess().getItemKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getItemKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__0__Impl"


    // $ANTLR start "rule__Item__Group__1"
    // InternalGames.g:3999:1: rule__Item__Group__1 : rule__Item__Group__1__Impl rule__Item__Group__2 ;
    public final void rule__Item__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4003:1: ( rule__Item__Group__1__Impl rule__Item__Group__2 )
            // InternalGames.g:4004:2: rule__Item__Group__1__Impl rule__Item__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Item__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__1"


    // $ANTLR start "rule__Item__Group__1__Impl"
    // InternalGames.g:4011:1: rule__Item__Group__1__Impl : ( ( rule__Item__NameAssignment_1 ) ) ;
    public final void rule__Item__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4015:1: ( ( ( rule__Item__NameAssignment_1 ) ) )
            // InternalGames.g:4016:1: ( ( rule__Item__NameAssignment_1 ) )
            {
            // InternalGames.g:4016:1: ( ( rule__Item__NameAssignment_1 ) )
            // InternalGames.g:4017:2: ( rule__Item__NameAssignment_1 )
            {
             before(grammarAccess.getItemAccess().getNameAssignment_1()); 
            // InternalGames.g:4018:2: ( rule__Item__NameAssignment_1 )
            // InternalGames.g:4018:3: rule__Item__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Item__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__1__Impl"


    // $ANTLR start "rule__Item__Group__2"
    // InternalGames.g:4026:1: rule__Item__Group__2 : rule__Item__Group__2__Impl rule__Item__Group__3 ;
    public final void rule__Item__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4030:1: ( rule__Item__Group__2__Impl rule__Item__Group__3 )
            // InternalGames.g:4031:2: rule__Item__Group__2__Impl rule__Item__Group__3
            {
            pushFollow(FOLLOW_38);
            rule__Item__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__2"


    // $ANTLR start "rule__Item__Group__2__Impl"
    // InternalGames.g:4038:1: rule__Item__Group__2__Impl : ( '{' ) ;
    public final void rule__Item__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4042:1: ( ( '{' ) )
            // InternalGames.g:4043:1: ( '{' )
            {
            // InternalGames.g:4043:1: ( '{' )
            // InternalGames.g:4044:2: '{'
            {
             before(grammarAccess.getItemAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__2__Impl"


    // $ANTLR start "rule__Item__Group__3"
    // InternalGames.g:4053:1: rule__Item__Group__3 : rule__Item__Group__3__Impl rule__Item__Group__4 ;
    public final void rule__Item__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4057:1: ( rule__Item__Group__3__Impl rule__Item__Group__4 )
            // InternalGames.g:4058:2: rule__Item__Group__3__Impl rule__Item__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Item__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__3"


    // $ANTLR start "rule__Item__Group__3__Impl"
    // InternalGames.g:4065:1: rule__Item__Group__3__Impl : ( 'size' ) ;
    public final void rule__Item__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4069:1: ( ( 'size' ) )
            // InternalGames.g:4070:1: ( 'size' )
            {
            // InternalGames.g:4070:1: ( 'size' )
            // InternalGames.g:4071:2: 'size'
            {
             before(grammarAccess.getItemAccess().getSizeKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getSizeKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__3__Impl"


    // $ANTLR start "rule__Item__Group__4"
    // InternalGames.g:4080:1: rule__Item__Group__4 : rule__Item__Group__4__Impl rule__Item__Group__5 ;
    public final void rule__Item__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4084:1: ( rule__Item__Group__4__Impl rule__Item__Group__5 )
            // InternalGames.g:4085:2: rule__Item__Group__4__Impl rule__Item__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__Item__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__4"


    // $ANTLR start "rule__Item__Group__4__Impl"
    // InternalGames.g:4092:1: rule__Item__Group__4__Impl : ( ( rule__Item__SizeAssignment_4 ) ) ;
    public final void rule__Item__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4096:1: ( ( ( rule__Item__SizeAssignment_4 ) ) )
            // InternalGames.g:4097:1: ( ( rule__Item__SizeAssignment_4 ) )
            {
            // InternalGames.g:4097:1: ( ( rule__Item__SizeAssignment_4 ) )
            // InternalGames.g:4098:2: ( rule__Item__SizeAssignment_4 )
            {
             before(grammarAccess.getItemAccess().getSizeAssignment_4()); 
            // InternalGames.g:4099:2: ( rule__Item__SizeAssignment_4 )
            // InternalGames.g:4099:3: rule__Item__SizeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Item__SizeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getSizeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__4__Impl"


    // $ANTLR start "rule__Item__Group__5"
    // InternalGames.g:4107:1: rule__Item__Group__5 : rule__Item__Group__5__Impl rule__Item__Group__6 ;
    public final void rule__Item__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4111:1: ( rule__Item__Group__5__Impl rule__Item__Group__6 )
            // InternalGames.g:4112:2: rule__Item__Group__5__Impl rule__Item__Group__6
            {
            pushFollow(FOLLOW_26);
            rule__Item__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__5"


    // $ANTLR start "rule__Item__Group__5__Impl"
    // InternalGames.g:4119:1: rule__Item__Group__5__Impl : ( 'description' ) ;
    public final void rule__Item__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4123:1: ( ( 'description' ) )
            // InternalGames.g:4124:1: ( 'description' )
            {
            // InternalGames.g:4124:1: ( 'description' )
            // InternalGames.g:4125:2: 'description'
            {
             before(grammarAccess.getItemAccess().getDescriptionKeyword_5()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getDescriptionKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__5__Impl"


    // $ANTLR start "rule__Item__Group__6"
    // InternalGames.g:4134:1: rule__Item__Group__6 : rule__Item__Group__6__Impl rule__Item__Group__7 ;
    public final void rule__Item__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4138:1: ( rule__Item__Group__6__Impl rule__Item__Group__7 )
            // InternalGames.g:4139:2: rule__Item__Group__6__Impl rule__Item__Group__7
            {
            pushFollow(FOLLOW_28);
            rule__Item__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__6"


    // $ANTLR start "rule__Item__Group__6__Impl"
    // InternalGames.g:4146:1: rule__Item__Group__6__Impl : ( ( rule__Item__DescriptionAssignment_6 ) ) ;
    public final void rule__Item__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4150:1: ( ( ( rule__Item__DescriptionAssignment_6 ) ) )
            // InternalGames.g:4151:1: ( ( rule__Item__DescriptionAssignment_6 ) )
            {
            // InternalGames.g:4151:1: ( ( rule__Item__DescriptionAssignment_6 ) )
            // InternalGames.g:4152:2: ( rule__Item__DescriptionAssignment_6 )
            {
             before(grammarAccess.getItemAccess().getDescriptionAssignment_6()); 
            // InternalGames.g:4153:2: ( rule__Item__DescriptionAssignment_6 )
            // InternalGames.g:4153:3: rule__Item__DescriptionAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Item__DescriptionAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getDescriptionAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__6__Impl"


    // $ANTLR start "rule__Item__Group__7"
    // InternalGames.g:4161:1: rule__Item__Group__7 : rule__Item__Group__7__Impl rule__Item__Group__8 ;
    public final void rule__Item__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4165:1: ( rule__Item__Group__7__Impl rule__Item__Group__8 )
            // InternalGames.g:4166:2: rule__Item__Group__7__Impl rule__Item__Group__8
            {
            pushFollow(FOLLOW_22);
            rule__Item__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__7"


    // $ANTLR start "rule__Item__Group__7__Impl"
    // InternalGames.g:4173:1: rule__Item__Group__7__Impl : ( 'visible' ) ;
    public final void rule__Item__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4177:1: ( ( 'visible' ) )
            // InternalGames.g:4178:1: ( 'visible' )
            {
            // InternalGames.g:4178:1: ( 'visible' )
            // InternalGames.g:4179:2: 'visible'
            {
             before(grammarAccess.getItemAccess().getVisibleKeyword_7()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getVisibleKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__7__Impl"


    // $ANTLR start "rule__Item__Group__8"
    // InternalGames.g:4188:1: rule__Item__Group__8 : rule__Item__Group__8__Impl rule__Item__Group__9 ;
    public final void rule__Item__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4192:1: ( rule__Item__Group__8__Impl rule__Item__Group__9 )
            // InternalGames.g:4193:2: rule__Item__Group__8__Impl rule__Item__Group__9
            {
            pushFollow(FOLLOW_29);
            rule__Item__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__8"


    // $ANTLR start "rule__Item__Group__8__Impl"
    // InternalGames.g:4200:1: rule__Item__Group__8__Impl : ( ( rule__Item__VisibleAssignment_8 ) ) ;
    public final void rule__Item__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4204:1: ( ( ( rule__Item__VisibleAssignment_8 ) ) )
            // InternalGames.g:4205:1: ( ( rule__Item__VisibleAssignment_8 ) )
            {
            // InternalGames.g:4205:1: ( ( rule__Item__VisibleAssignment_8 ) )
            // InternalGames.g:4206:2: ( rule__Item__VisibleAssignment_8 )
            {
             before(grammarAccess.getItemAccess().getVisibleAssignment_8()); 
            // InternalGames.g:4207:2: ( rule__Item__VisibleAssignment_8 )
            // InternalGames.g:4207:3: rule__Item__VisibleAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Item__VisibleAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getVisibleAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__8__Impl"


    // $ANTLR start "rule__Item__Group__9"
    // InternalGames.g:4215:1: rule__Item__Group__9 : rule__Item__Group__9__Impl rule__Item__Group__10 ;
    public final void rule__Item__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4219:1: ( rule__Item__Group__9__Impl rule__Item__Group__10 )
            // InternalGames.g:4220:2: rule__Item__Group__9__Impl rule__Item__Group__10
            {
            pushFollow(FOLLOW_29);
            rule__Item__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__9"


    // $ANTLR start "rule__Item__Group__9__Impl"
    // InternalGames.g:4227:1: rule__Item__Group__9__Impl : ( ( rule__Item__Group_9__0 )? ) ;
    public final void rule__Item__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4231:1: ( ( ( rule__Item__Group_9__0 )? ) )
            // InternalGames.g:4232:1: ( ( rule__Item__Group_9__0 )? )
            {
            // InternalGames.g:4232:1: ( ( rule__Item__Group_9__0 )? )
            // InternalGames.g:4233:2: ( rule__Item__Group_9__0 )?
            {
             before(grammarAccess.getItemAccess().getGroup_9()); 
            // InternalGames.g:4234:2: ( rule__Item__Group_9__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGames.g:4234:3: rule__Item__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Item__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getItemAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__9__Impl"


    // $ANTLR start "rule__Item__Group__10"
    // InternalGames.g:4242:1: rule__Item__Group__10 : rule__Item__Group__10__Impl rule__Item__Group__11 ;
    public final void rule__Item__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4246:1: ( rule__Item__Group__10__Impl rule__Item__Group__11 )
            // InternalGames.g:4247:2: rule__Item__Group__10__Impl rule__Item__Group__11
            {
            pushFollow(FOLLOW_22);
            rule__Item__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__10"


    // $ANTLR start "rule__Item__Group__10__Impl"
    // InternalGames.g:4254:1: rule__Item__Group__10__Impl : ( 'active' ) ;
    public final void rule__Item__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4258:1: ( ( 'active' ) )
            // InternalGames.g:4259:1: ( 'active' )
            {
            // InternalGames.g:4259:1: ( 'active' )
            // InternalGames.g:4260:2: 'active'
            {
             before(grammarAccess.getItemAccess().getActiveKeyword_10()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getActiveKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__10__Impl"


    // $ANTLR start "rule__Item__Group__11"
    // InternalGames.g:4269:1: rule__Item__Group__11 : rule__Item__Group__11__Impl rule__Item__Group__12 ;
    public final void rule__Item__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4273:1: ( rule__Item__Group__11__Impl rule__Item__Group__12 )
            // InternalGames.g:4274:2: rule__Item__Group__11__Impl rule__Item__Group__12
            {
            pushFollow(FOLLOW_39);
            rule__Item__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__11"


    // $ANTLR start "rule__Item__Group__11__Impl"
    // InternalGames.g:4281:1: rule__Item__Group__11__Impl : ( ( rule__Item__ActiveAssignment_11 ) ) ;
    public final void rule__Item__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4285:1: ( ( ( rule__Item__ActiveAssignment_11 ) ) )
            // InternalGames.g:4286:1: ( ( rule__Item__ActiveAssignment_11 ) )
            {
            // InternalGames.g:4286:1: ( ( rule__Item__ActiveAssignment_11 ) )
            // InternalGames.g:4287:2: ( rule__Item__ActiveAssignment_11 )
            {
             before(grammarAccess.getItemAccess().getActiveAssignment_11()); 
            // InternalGames.g:4288:2: ( rule__Item__ActiveAssignment_11 )
            // InternalGames.g:4288:3: rule__Item__ActiveAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Item__ActiveAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getActiveAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__11__Impl"


    // $ANTLR start "rule__Item__Group__12"
    // InternalGames.g:4296:1: rule__Item__Group__12 : rule__Item__Group__12__Impl rule__Item__Group__13 ;
    public final void rule__Item__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4300:1: ( rule__Item__Group__12__Impl rule__Item__Group__13 )
            // InternalGames.g:4301:2: rule__Item__Group__12__Impl rule__Item__Group__13
            {
            pushFollow(FOLLOW_40);
            rule__Item__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__12"


    // $ANTLR start "rule__Item__Group__12__Impl"
    // InternalGames.g:4308:1: rule__Item__Group__12__Impl : ( 'conditionsActive' ) ;
    public final void rule__Item__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4312:1: ( ( 'conditionsActive' ) )
            // InternalGames.g:4313:1: ( 'conditionsActive' )
            {
            // InternalGames.g:4313:1: ( 'conditionsActive' )
            // InternalGames.g:4314:2: 'conditionsActive'
            {
             before(grammarAccess.getItemAccess().getConditionsActiveKeyword_12()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getConditionsActiveKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__12__Impl"


    // $ANTLR start "rule__Item__Group__13"
    // InternalGames.g:4323:1: rule__Item__Group__13 : rule__Item__Group__13__Impl rule__Item__Group__14 ;
    public final void rule__Item__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4327:1: ( rule__Item__Group__13__Impl rule__Item__Group__14 )
            // InternalGames.g:4328:2: rule__Item__Group__13__Impl rule__Item__Group__14
            {
            pushFollow(FOLLOW_40);
            rule__Item__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__13"


    // $ANTLR start "rule__Item__Group__13__Impl"
    // InternalGames.g:4335:1: rule__Item__Group__13__Impl : ( ( rule__Item__ConditionsActiveAssignment_13 )* ) ;
    public final void rule__Item__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4339:1: ( ( ( rule__Item__ConditionsActiveAssignment_13 )* ) )
            // InternalGames.g:4340:1: ( ( rule__Item__ConditionsActiveAssignment_13 )* )
            {
            // InternalGames.g:4340:1: ( ( rule__Item__ConditionsActiveAssignment_13 )* )
            // InternalGames.g:4341:2: ( rule__Item__ConditionsActiveAssignment_13 )*
            {
             before(grammarAccess.getItemAccess().getConditionsActiveAssignment_13()); 
            // InternalGames.g:4342:2: ( rule__Item__ConditionsActiveAssignment_13 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==59) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalGames.g:4342:3: rule__Item__ConditionsActiveAssignment_13
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Item__ConditionsActiveAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getItemAccess().getConditionsActiveAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__13__Impl"


    // $ANTLR start "rule__Item__Group__14"
    // InternalGames.g:4350:1: rule__Item__Group__14 : rule__Item__Group__14__Impl rule__Item__Group__15 ;
    public final void rule__Item__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4354:1: ( rule__Item__Group__14__Impl rule__Item__Group__15 )
            // InternalGames.g:4355:2: rule__Item__Group__14__Impl rule__Item__Group__15
            {
            pushFollow(FOLLOW_22);
            rule__Item__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__14"


    // $ANTLR start "rule__Item__Group__14__Impl"
    // InternalGames.g:4362:1: rule__Item__Group__14__Impl : ( 'canPutDown' ) ;
    public final void rule__Item__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4366:1: ( ( 'canPutDown' ) )
            // InternalGames.g:4367:1: ( 'canPutDown' )
            {
            // InternalGames.g:4367:1: ( 'canPutDown' )
            // InternalGames.g:4368:2: 'canPutDown'
            {
             before(grammarAccess.getItemAccess().getCanPutDownKeyword_14()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getCanPutDownKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__14__Impl"


    // $ANTLR start "rule__Item__Group__15"
    // InternalGames.g:4377:1: rule__Item__Group__15 : rule__Item__Group__15__Impl rule__Item__Group__16 ;
    public final void rule__Item__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4381:1: ( rule__Item__Group__15__Impl rule__Item__Group__16 )
            // InternalGames.g:4382:2: rule__Item__Group__15__Impl rule__Item__Group__16
            {
            pushFollow(FOLLOW_41);
            rule__Item__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__15"


    // $ANTLR start "rule__Item__Group__15__Impl"
    // InternalGames.g:4389:1: rule__Item__Group__15__Impl : ( ( rule__Item__CanPutDownAssignment_15 ) ) ;
    public final void rule__Item__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4393:1: ( ( ( rule__Item__CanPutDownAssignment_15 ) ) )
            // InternalGames.g:4394:1: ( ( rule__Item__CanPutDownAssignment_15 ) )
            {
            // InternalGames.g:4394:1: ( ( rule__Item__CanPutDownAssignment_15 ) )
            // InternalGames.g:4395:2: ( rule__Item__CanPutDownAssignment_15 )
            {
             before(grammarAccess.getItemAccess().getCanPutDownAssignment_15()); 
            // InternalGames.g:4396:2: ( rule__Item__CanPutDownAssignment_15 )
            // InternalGames.g:4396:3: rule__Item__CanPutDownAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Item__CanPutDownAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getItemAccess().getCanPutDownAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__15__Impl"


    // $ANTLR start "rule__Item__Group__16"
    // InternalGames.g:4404:1: rule__Item__Group__16 : rule__Item__Group__16__Impl rule__Item__Group__17 ;
    public final void rule__Item__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4408:1: ( rule__Item__Group__16__Impl rule__Item__Group__17 )
            // InternalGames.g:4409:2: rule__Item__Group__16__Impl rule__Item__Group__17
            {
            pushFollow(FOLLOW_41);
            rule__Item__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__16"


    // $ANTLR start "rule__Item__Group__16__Impl"
    // InternalGames.g:4416:1: rule__Item__Group__16__Impl : ( ( rule__Item__Group_16__0 )? ) ;
    public final void rule__Item__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4420:1: ( ( ( rule__Item__Group_16__0 )? ) )
            // InternalGames.g:4421:1: ( ( rule__Item__Group_16__0 )? )
            {
            // InternalGames.g:4421:1: ( ( rule__Item__Group_16__0 )? )
            // InternalGames.g:4422:2: ( rule__Item__Group_16__0 )?
            {
             before(grammarAccess.getItemAccess().getGroup_16()); 
            // InternalGames.g:4423:2: ( rule__Item__Group_16__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==48) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalGames.g:4423:3: rule__Item__Group_16__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Item__Group_16__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getItemAccess().getGroup_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__16__Impl"


    // $ANTLR start "rule__Item__Group__17"
    // InternalGames.g:4431:1: rule__Item__Group__17 : rule__Item__Group__17__Impl rule__Item__Group__18 ;
    public final void rule__Item__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4435:1: ( rule__Item__Group__17__Impl rule__Item__Group__18 )
            // InternalGames.g:4436:2: rule__Item__Group__17__Impl rule__Item__Group__18
            {
            pushFollow(FOLLOW_41);
            rule__Item__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__17"


    // $ANTLR start "rule__Item__Group__17__Impl"
    // InternalGames.g:4443:1: rule__Item__Group__17__Impl : ( ( rule__Item__Group_17__0 )? ) ;
    public final void rule__Item__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4447:1: ( ( ( rule__Item__Group_17__0 )? ) )
            // InternalGames.g:4448:1: ( ( rule__Item__Group_17__0 )? )
            {
            // InternalGames.g:4448:1: ( ( rule__Item__Group_17__0 )? )
            // InternalGames.g:4449:2: ( rule__Item__Group_17__0 )?
            {
             before(grammarAccess.getItemAccess().getGroup_17()); 
            // InternalGames.g:4450:2: ( rule__Item__Group_17__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==49) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalGames.g:4450:3: rule__Item__Group_17__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Item__Group_17__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getItemAccess().getGroup_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__17__Impl"


    // $ANTLR start "rule__Item__Group__18"
    // InternalGames.g:4458:1: rule__Item__Group__18 : rule__Item__Group__18__Impl rule__Item__Group__19 ;
    public final void rule__Item__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4462:1: ( rule__Item__Group__18__Impl rule__Item__Group__19 )
            // InternalGames.g:4463:2: rule__Item__Group__18__Impl rule__Item__Group__19
            {
            pushFollow(FOLLOW_41);
            rule__Item__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__18"


    // $ANTLR start "rule__Item__Group__18__Impl"
    // InternalGames.g:4470:1: rule__Item__Group__18__Impl : ( ( rule__Item__Group_18__0 )? ) ;
    public final void rule__Item__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4474:1: ( ( ( rule__Item__Group_18__0 )? ) )
            // InternalGames.g:4475:1: ( ( rule__Item__Group_18__0 )? )
            {
            // InternalGames.g:4475:1: ( ( rule__Item__Group_18__0 )? )
            // InternalGames.g:4476:2: ( rule__Item__Group_18__0 )?
            {
             before(grammarAccess.getItemAccess().getGroup_18()); 
            // InternalGames.g:4477:2: ( rule__Item__Group_18__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==50) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalGames.g:4477:3: rule__Item__Group_18__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Item__Group_18__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getItemAccess().getGroup_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__18__Impl"


    // $ANTLR start "rule__Item__Group__19"
    // InternalGames.g:4485:1: rule__Item__Group__19 : rule__Item__Group__19__Impl ;
    public final void rule__Item__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4489:1: ( rule__Item__Group__19__Impl )
            // InternalGames.g:4490:2: rule__Item__Group__19__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group__19__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__19"


    // $ANTLR start "rule__Item__Group__19__Impl"
    // InternalGames.g:4496:1: rule__Item__Group__19__Impl : ( '}' ) ;
    public final void rule__Item__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4500:1: ( ( '}' ) )
            // InternalGames.g:4501:1: ( '}' )
            {
            // InternalGames.g:4501:1: ( '}' )
            // InternalGames.g:4502:2: '}'
            {
             before(grammarAccess.getItemAccess().getRightCurlyBracketKeyword_19()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getRightCurlyBracketKeyword_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group__19__Impl"


    // $ANTLR start "rule__Item__Group_9__0"
    // InternalGames.g:4512:1: rule__Item__Group_9__0 : rule__Item__Group_9__0__Impl rule__Item__Group_9__1 ;
    public final void rule__Item__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4516:1: ( rule__Item__Group_9__0__Impl rule__Item__Group_9__1 )
            // InternalGames.g:4517:2: rule__Item__Group_9__0__Impl rule__Item__Group_9__1
            {
            pushFollow(FOLLOW_32);
            rule__Item__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_9__0"


    // $ANTLR start "rule__Item__Group_9__0__Impl"
    // InternalGames.g:4524:1: rule__Item__Group_9__0__Impl : ( 'conditionsVisible' ) ;
    public final void rule__Item__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4528:1: ( ( 'conditionsVisible' ) )
            // InternalGames.g:4529:1: ( 'conditionsVisible' )
            {
            // InternalGames.g:4529:1: ( 'conditionsVisible' )
            // InternalGames.g:4530:2: 'conditionsVisible'
            {
             before(grammarAccess.getItemAccess().getConditionsVisibleKeyword_9_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getConditionsVisibleKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_9__0__Impl"


    // $ANTLR start "rule__Item__Group_9__1"
    // InternalGames.g:4539:1: rule__Item__Group_9__1 : rule__Item__Group_9__1__Impl ;
    public final void rule__Item__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4543:1: ( rule__Item__Group_9__1__Impl )
            // InternalGames.g:4544:2: rule__Item__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_9__1"


    // $ANTLR start "rule__Item__Group_9__1__Impl"
    // InternalGames.g:4550:1: rule__Item__Group_9__1__Impl : ( ( rule__Item__ConditionsVisibleAssignment_9_1 )* ) ;
    public final void rule__Item__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4554:1: ( ( ( rule__Item__ConditionsVisibleAssignment_9_1 )* ) )
            // InternalGames.g:4555:1: ( ( rule__Item__ConditionsVisibleAssignment_9_1 )* )
            {
            // InternalGames.g:4555:1: ( ( rule__Item__ConditionsVisibleAssignment_9_1 )* )
            // InternalGames.g:4556:2: ( rule__Item__ConditionsVisibleAssignment_9_1 )*
            {
             before(grammarAccess.getItemAccess().getConditionsVisibleAssignment_9_1()); 
            // InternalGames.g:4557:2: ( rule__Item__ConditionsVisibleAssignment_9_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==59) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalGames.g:4557:3: rule__Item__ConditionsVisibleAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Item__ConditionsVisibleAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getItemAccess().getConditionsVisibleAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_9__1__Impl"


    // $ANTLR start "rule__Item__Group_16__0"
    // InternalGames.g:4566:1: rule__Item__Group_16__0 : rule__Item__Group_16__0__Impl rule__Item__Group_16__1 ;
    public final void rule__Item__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4570:1: ( rule__Item__Group_16__0__Impl rule__Item__Group_16__1 )
            // InternalGames.g:4571:2: rule__Item__Group_16__0__Impl rule__Item__Group_16__1
            {
            pushFollow(FOLLOW_32);
            rule__Item__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group_16__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_16__0"


    // $ANTLR start "rule__Item__Group_16__0__Impl"
    // InternalGames.g:4578:1: rule__Item__Group_16__0__Impl : ( 'conditionsPutDown' ) ;
    public final void rule__Item__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4582:1: ( ( 'conditionsPutDown' ) )
            // InternalGames.g:4583:1: ( 'conditionsPutDown' )
            {
            // InternalGames.g:4583:1: ( 'conditionsPutDown' )
            // InternalGames.g:4584:2: 'conditionsPutDown'
            {
             before(grammarAccess.getItemAccess().getConditionsPutDownKeyword_16_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getConditionsPutDownKeyword_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_16__0__Impl"


    // $ANTLR start "rule__Item__Group_16__1"
    // InternalGames.g:4593:1: rule__Item__Group_16__1 : rule__Item__Group_16__1__Impl ;
    public final void rule__Item__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4597:1: ( rule__Item__Group_16__1__Impl )
            // InternalGames.g:4598:2: rule__Item__Group_16__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group_16__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_16__1"


    // $ANTLR start "rule__Item__Group_16__1__Impl"
    // InternalGames.g:4604:1: rule__Item__Group_16__1__Impl : ( ( rule__Item__ConditionsPutDownAssignment_16_1 )* ) ;
    public final void rule__Item__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4608:1: ( ( ( rule__Item__ConditionsPutDownAssignment_16_1 )* ) )
            // InternalGames.g:4609:1: ( ( rule__Item__ConditionsPutDownAssignment_16_1 )* )
            {
            // InternalGames.g:4609:1: ( ( rule__Item__ConditionsPutDownAssignment_16_1 )* )
            // InternalGames.g:4610:2: ( rule__Item__ConditionsPutDownAssignment_16_1 )*
            {
             before(grammarAccess.getItemAccess().getConditionsPutDownAssignment_16_1()); 
            // InternalGames.g:4611:2: ( rule__Item__ConditionsPutDownAssignment_16_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==59) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalGames.g:4611:3: rule__Item__ConditionsPutDownAssignment_16_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Item__ConditionsPutDownAssignment_16_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getItemAccess().getConditionsPutDownAssignment_16_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_16__1__Impl"


    // $ANTLR start "rule__Item__Group_17__0"
    // InternalGames.g:4620:1: rule__Item__Group_17__0 : rule__Item__Group_17__0__Impl rule__Item__Group_17__1 ;
    public final void rule__Item__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4624:1: ( rule__Item__Group_17__0__Impl rule__Item__Group_17__1 )
            // InternalGames.g:4625:2: rule__Item__Group_17__0__Impl rule__Item__Group_17__1
            {
            pushFollow(FOLLOW_32);
            rule__Item__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group_17__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_17__0"


    // $ANTLR start "rule__Item__Group_17__0__Impl"
    // InternalGames.g:4632:1: rule__Item__Group_17__0__Impl : ( 'conditionsGive' ) ;
    public final void rule__Item__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4636:1: ( ( 'conditionsGive' ) )
            // InternalGames.g:4637:1: ( 'conditionsGive' )
            {
            // InternalGames.g:4637:1: ( 'conditionsGive' )
            // InternalGames.g:4638:2: 'conditionsGive'
            {
             before(grammarAccess.getItemAccess().getConditionsGiveKeyword_17_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getConditionsGiveKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_17__0__Impl"


    // $ANTLR start "rule__Item__Group_17__1"
    // InternalGames.g:4647:1: rule__Item__Group_17__1 : rule__Item__Group_17__1__Impl ;
    public final void rule__Item__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4651:1: ( rule__Item__Group_17__1__Impl )
            // InternalGames.g:4652:2: rule__Item__Group_17__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group_17__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_17__1"


    // $ANTLR start "rule__Item__Group_17__1__Impl"
    // InternalGames.g:4658:1: rule__Item__Group_17__1__Impl : ( ( rule__Item__ConditionsGiveAssignment_17_1 )* ) ;
    public final void rule__Item__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4662:1: ( ( ( rule__Item__ConditionsGiveAssignment_17_1 )* ) )
            // InternalGames.g:4663:1: ( ( rule__Item__ConditionsGiveAssignment_17_1 )* )
            {
            // InternalGames.g:4663:1: ( ( rule__Item__ConditionsGiveAssignment_17_1 )* )
            // InternalGames.g:4664:2: ( rule__Item__ConditionsGiveAssignment_17_1 )*
            {
             before(grammarAccess.getItemAccess().getConditionsGiveAssignment_17_1()); 
            // InternalGames.g:4665:2: ( rule__Item__ConditionsGiveAssignment_17_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==59) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalGames.g:4665:3: rule__Item__ConditionsGiveAssignment_17_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Item__ConditionsGiveAssignment_17_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getItemAccess().getConditionsGiveAssignment_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_17__1__Impl"


    // $ANTLR start "rule__Item__Group_18__0"
    // InternalGames.g:4674:1: rule__Item__Group_18__0 : rule__Item__Group_18__0__Impl rule__Item__Group_18__1 ;
    public final void rule__Item__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4678:1: ( rule__Item__Group_18__0__Impl rule__Item__Group_18__1 )
            // InternalGames.g:4679:2: rule__Item__Group_18__0__Impl rule__Item__Group_18__1
            {
            pushFollow(FOLLOW_32);
            rule__Item__Group_18__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Item__Group_18__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_18__0"


    // $ANTLR start "rule__Item__Group_18__0__Impl"
    // InternalGames.g:4686:1: rule__Item__Group_18__0__Impl : ( 'conditionsConsumed' ) ;
    public final void rule__Item__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4690:1: ( ( 'conditionsConsumed' ) )
            // InternalGames.g:4691:1: ( 'conditionsConsumed' )
            {
            // InternalGames.g:4691:1: ( 'conditionsConsumed' )
            // InternalGames.g:4692:2: 'conditionsConsumed'
            {
             before(grammarAccess.getItemAccess().getConditionsConsumedKeyword_18_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getConditionsConsumedKeyword_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_18__0__Impl"


    // $ANTLR start "rule__Item__Group_18__1"
    // InternalGames.g:4701:1: rule__Item__Group_18__1 : rule__Item__Group_18__1__Impl ;
    public final void rule__Item__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4705:1: ( rule__Item__Group_18__1__Impl )
            // InternalGames.g:4706:2: rule__Item__Group_18__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Item__Group_18__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_18__1"


    // $ANTLR start "rule__Item__Group_18__1__Impl"
    // InternalGames.g:4712:1: rule__Item__Group_18__1__Impl : ( ( rule__Item__ConditionsConsumedAssignment_18_1 )* ) ;
    public final void rule__Item__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4716:1: ( ( ( rule__Item__ConditionsConsumedAssignment_18_1 )* ) )
            // InternalGames.g:4717:1: ( ( rule__Item__ConditionsConsumedAssignment_18_1 )* )
            {
            // InternalGames.g:4717:1: ( ( rule__Item__ConditionsConsumedAssignment_18_1 )* )
            // InternalGames.g:4718:2: ( rule__Item__ConditionsConsumedAssignment_18_1 )*
            {
             before(grammarAccess.getItemAccess().getConditionsConsumedAssignment_18_1()); 
            // InternalGames.g:4719:2: ( rule__Item__ConditionsConsumedAssignment_18_1 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==59) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalGames.g:4719:3: rule__Item__ConditionsConsumedAssignment_18_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Item__ConditionsConsumedAssignment_18_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getItemAccess().getConditionsConsumedAssignment_18_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__Group_18__1__Impl"


    // $ANTLR start "rule__ItemInSomething__Group__0"
    // InternalGames.g:4728:1: rule__ItemInSomething__Group__0 : rule__ItemInSomething__Group__0__Impl rule__ItemInSomething__Group__1 ;
    public final void rule__ItemInSomething__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4732:1: ( rule__ItemInSomething__Group__0__Impl rule__ItemInSomething__Group__1 )
            // InternalGames.g:4733:2: rule__ItemInSomething__Group__0__Impl rule__ItemInSomething__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__ItemInSomething__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInSomething__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__0"


    // $ANTLR start "rule__ItemInSomething__Group__0__Impl"
    // InternalGames.g:4740:1: rule__ItemInSomething__Group__0__Impl : ( ( rule__ItemInSomething__ItemAssignment_0 ) ) ;
    public final void rule__ItemInSomething__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4744:1: ( ( ( rule__ItemInSomething__ItemAssignment_0 ) ) )
            // InternalGames.g:4745:1: ( ( rule__ItemInSomething__ItemAssignment_0 ) )
            {
            // InternalGames.g:4745:1: ( ( rule__ItemInSomething__ItemAssignment_0 ) )
            // InternalGames.g:4746:2: ( rule__ItemInSomething__ItemAssignment_0 )
            {
             before(grammarAccess.getItemInSomethingAccess().getItemAssignment_0()); 
            // InternalGames.g:4747:2: ( rule__ItemInSomething__ItemAssignment_0 )
            // InternalGames.g:4747:3: rule__ItemInSomething__ItemAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ItemInSomething__ItemAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getItemInSomethingAccess().getItemAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__0__Impl"


    // $ANTLR start "rule__ItemInSomething__Group__1"
    // InternalGames.g:4755:1: rule__ItemInSomething__Group__1 : rule__ItemInSomething__Group__1__Impl rule__ItemInSomething__Group__2 ;
    public final void rule__ItemInSomething__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4759:1: ( rule__ItemInSomething__Group__1__Impl rule__ItemInSomething__Group__2 )
            // InternalGames.g:4760:2: rule__ItemInSomething__Group__1__Impl rule__ItemInSomething__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__ItemInSomething__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInSomething__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__1"


    // $ANTLR start "rule__ItemInSomething__Group__1__Impl"
    // InternalGames.g:4767:1: rule__ItemInSomething__Group__1__Impl : ( '(' ) ;
    public final void rule__ItemInSomething__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4771:1: ( ( '(' ) )
            // InternalGames.g:4772:1: ( '(' )
            {
            // InternalGames.g:4772:1: ( '(' )
            // InternalGames.g:4773:2: '('
            {
             before(grammarAccess.getItemInSomethingAccess().getLeftParenthesisKeyword_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getItemInSomethingAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__1__Impl"


    // $ANTLR start "rule__ItemInSomething__Group__2"
    // InternalGames.g:4782:1: rule__ItemInSomething__Group__2 : rule__ItemInSomething__Group__2__Impl rule__ItemInSomething__Group__3 ;
    public final void rule__ItemInSomething__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4786:1: ( rule__ItemInSomething__Group__2__Impl rule__ItemInSomething__Group__3 )
            // InternalGames.g:4787:2: rule__ItemInSomething__Group__2__Impl rule__ItemInSomething__Group__3
            {
            pushFollow(FOLLOW_43);
            rule__ItemInSomething__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInSomething__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__2"


    // $ANTLR start "rule__ItemInSomething__Group__2__Impl"
    // InternalGames.g:4794:1: rule__ItemInSomething__Group__2__Impl : ( ( rule__ItemInSomething__QuantiteAssignment_2 ) ) ;
    public final void rule__ItemInSomething__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4798:1: ( ( ( rule__ItemInSomething__QuantiteAssignment_2 ) ) )
            // InternalGames.g:4799:1: ( ( rule__ItemInSomething__QuantiteAssignment_2 ) )
            {
            // InternalGames.g:4799:1: ( ( rule__ItemInSomething__QuantiteAssignment_2 ) )
            // InternalGames.g:4800:2: ( rule__ItemInSomething__QuantiteAssignment_2 )
            {
             before(grammarAccess.getItemInSomethingAccess().getQuantiteAssignment_2()); 
            // InternalGames.g:4801:2: ( rule__ItemInSomething__QuantiteAssignment_2 )
            // InternalGames.g:4801:3: rule__ItemInSomething__QuantiteAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ItemInSomething__QuantiteAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getItemInSomethingAccess().getQuantiteAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__2__Impl"


    // $ANTLR start "rule__ItemInSomething__Group__3"
    // InternalGames.g:4809:1: rule__ItemInSomething__Group__3 : rule__ItemInSomething__Group__3__Impl ;
    public final void rule__ItemInSomething__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4813:1: ( rule__ItemInSomething__Group__3__Impl )
            // InternalGames.g:4814:2: rule__ItemInSomething__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ItemInSomething__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__3"


    // $ANTLR start "rule__ItemInSomething__Group__3__Impl"
    // InternalGames.g:4820:1: rule__ItemInSomething__Group__3__Impl : ( ')' ) ;
    public final void rule__ItemInSomething__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4824:1: ( ( ')' ) )
            // InternalGames.g:4825:1: ( ')' )
            {
            // InternalGames.g:4825:1: ( ')' )
            // InternalGames.g:4826:2: ')'
            {
             before(grammarAccess.getItemInSomethingAccess().getRightParenthesisKeyword_3()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getItemInSomethingAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__Group__3__Impl"


    // $ANTLR start "rule__Recipe__Group__0"
    // InternalGames.g:4836:1: rule__Recipe__Group__0 : rule__Recipe__Group__0__Impl rule__Recipe__Group__1 ;
    public final void rule__Recipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4840:1: ( rule__Recipe__Group__0__Impl rule__Recipe__Group__1 )
            // InternalGames.g:4841:2: rule__Recipe__Group__0__Impl rule__Recipe__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Recipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__0"


    // $ANTLR start "rule__Recipe__Group__0__Impl"
    // InternalGames.g:4848:1: rule__Recipe__Group__0__Impl : ( 'recipe' ) ;
    public final void rule__Recipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4852:1: ( ( 'recipe' ) )
            // InternalGames.g:4853:1: ( 'recipe' )
            {
            // InternalGames.g:4853:1: ( 'recipe' )
            // InternalGames.g:4854:2: 'recipe'
            {
             before(grammarAccess.getRecipeAccess().getRecipeKeyword_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getRecipeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__0__Impl"


    // $ANTLR start "rule__Recipe__Group__1"
    // InternalGames.g:4863:1: rule__Recipe__Group__1 : rule__Recipe__Group__1__Impl rule__Recipe__Group__2 ;
    public final void rule__Recipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4867:1: ( rule__Recipe__Group__1__Impl rule__Recipe__Group__2 )
            // InternalGames.g:4868:2: rule__Recipe__Group__1__Impl rule__Recipe__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Recipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__1"


    // $ANTLR start "rule__Recipe__Group__1__Impl"
    // InternalGames.g:4875:1: rule__Recipe__Group__1__Impl : ( ( rule__Recipe__NameAssignment_1 ) ) ;
    public final void rule__Recipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4879:1: ( ( ( rule__Recipe__NameAssignment_1 ) ) )
            // InternalGames.g:4880:1: ( ( rule__Recipe__NameAssignment_1 ) )
            {
            // InternalGames.g:4880:1: ( ( rule__Recipe__NameAssignment_1 ) )
            // InternalGames.g:4881:2: ( rule__Recipe__NameAssignment_1 )
            {
             before(grammarAccess.getRecipeAccess().getNameAssignment_1()); 
            // InternalGames.g:4882:2: ( rule__Recipe__NameAssignment_1 )
            // InternalGames.g:4882:3: rule__Recipe__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Recipe__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRecipeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__1__Impl"


    // $ANTLR start "rule__Recipe__Group__2"
    // InternalGames.g:4890:1: rule__Recipe__Group__2 : rule__Recipe__Group__2__Impl rule__Recipe__Group__3 ;
    public final void rule__Recipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4894:1: ( rule__Recipe__Group__2__Impl rule__Recipe__Group__3 )
            // InternalGames.g:4895:2: rule__Recipe__Group__2__Impl rule__Recipe__Group__3
            {
            pushFollow(FOLLOW_44);
            rule__Recipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__2"


    // $ANTLR start "rule__Recipe__Group__2__Impl"
    // InternalGames.g:4902:1: rule__Recipe__Group__2__Impl : ( '{' ) ;
    public final void rule__Recipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4906:1: ( ( '{' ) )
            // InternalGames.g:4907:1: ( '{' )
            {
            // InternalGames.g:4907:1: ( '{' )
            // InternalGames.g:4908:2: '{'
            {
             before(grammarAccess.getRecipeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__2__Impl"


    // $ANTLR start "rule__Recipe__Group__3"
    // InternalGames.g:4917:1: rule__Recipe__Group__3 : rule__Recipe__Group__3__Impl rule__Recipe__Group__4 ;
    public final void rule__Recipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4921:1: ( rule__Recipe__Group__3__Impl rule__Recipe__Group__4 )
            // InternalGames.g:4922:2: rule__Recipe__Group__3__Impl rule__Recipe__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__Recipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__3"


    // $ANTLR start "rule__Recipe__Group__3__Impl"
    // InternalGames.g:4929:1: rule__Recipe__Group__3__Impl : ( 'itemsUsed' ) ;
    public final void rule__Recipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4933:1: ( ( 'itemsUsed' ) )
            // InternalGames.g:4934:1: ( 'itemsUsed' )
            {
            // InternalGames.g:4934:1: ( 'itemsUsed' )
            // InternalGames.g:4935:2: 'itemsUsed'
            {
             before(grammarAccess.getRecipeAccess().getItemsUsedKeyword_3()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getItemsUsedKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__3__Impl"


    // $ANTLR start "rule__Recipe__Group__4"
    // InternalGames.g:4944:1: rule__Recipe__Group__4 : rule__Recipe__Group__4__Impl rule__Recipe__Group__5 ;
    public final void rule__Recipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4948:1: ( rule__Recipe__Group__4__Impl rule__Recipe__Group__5 )
            // InternalGames.g:4949:2: rule__Recipe__Group__4__Impl rule__Recipe__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__Recipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__4"


    // $ANTLR start "rule__Recipe__Group__4__Impl"
    // InternalGames.g:4956:1: rule__Recipe__Group__4__Impl : ( ( rule__Recipe__ObjectsUsedAssignment_4 )* ) ;
    public final void rule__Recipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4960:1: ( ( ( rule__Recipe__ObjectsUsedAssignment_4 )* ) )
            // InternalGames.g:4961:1: ( ( rule__Recipe__ObjectsUsedAssignment_4 )* )
            {
            // InternalGames.g:4961:1: ( ( rule__Recipe__ObjectsUsedAssignment_4 )* )
            // InternalGames.g:4962:2: ( rule__Recipe__ObjectsUsedAssignment_4 )*
            {
             before(grammarAccess.getRecipeAccess().getObjectsUsedAssignment_4()); 
            // InternalGames.g:4963:2: ( rule__Recipe__ObjectsUsedAssignment_4 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalGames.g:4963:3: rule__Recipe__ObjectsUsedAssignment_4
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Recipe__ObjectsUsedAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getRecipeAccess().getObjectsUsedAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__4__Impl"


    // $ANTLR start "rule__Recipe__Group__5"
    // InternalGames.g:4971:1: rule__Recipe__Group__5 : rule__Recipe__Group__5__Impl rule__Recipe__Group__6 ;
    public final void rule__Recipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4975:1: ( rule__Recipe__Group__5__Impl rule__Recipe__Group__6 )
            // InternalGames.g:4976:2: rule__Recipe__Group__5__Impl rule__Recipe__Group__6
            {
            pushFollow(FOLLOW_45);
            rule__Recipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__5"


    // $ANTLR start "rule__Recipe__Group__5__Impl"
    // InternalGames.g:4983:1: rule__Recipe__Group__5__Impl : ( ( rule__Recipe__Group_5__0 )? ) ;
    public final void rule__Recipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:4987:1: ( ( ( rule__Recipe__Group_5__0 )? ) )
            // InternalGames.g:4988:1: ( ( rule__Recipe__Group_5__0 )? )
            {
            // InternalGames.g:4988:1: ( ( rule__Recipe__Group_5__0 )? )
            // InternalGames.g:4989:2: ( rule__Recipe__Group_5__0 )?
            {
             before(grammarAccess.getRecipeAccess().getGroup_5()); 
            // InternalGames.g:4990:2: ( rule__Recipe__Group_5__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalGames.g:4990:3: rule__Recipe__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Recipe__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRecipeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__5__Impl"


    // $ANTLR start "rule__Recipe__Group__6"
    // InternalGames.g:4998:1: rule__Recipe__Group__6 : rule__Recipe__Group__6__Impl rule__Recipe__Group__7 ;
    public final void rule__Recipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5002:1: ( rule__Recipe__Group__6__Impl rule__Recipe__Group__7 )
            // InternalGames.g:5003:2: rule__Recipe__Group__6__Impl rule__Recipe__Group__7
            {
            pushFollow(FOLLOW_46);
            rule__Recipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__6"


    // $ANTLR start "rule__Recipe__Group__6__Impl"
    // InternalGames.g:5010:1: rule__Recipe__Group__6__Impl : ( 'itemsMade' ) ;
    public final void rule__Recipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5014:1: ( ( 'itemsMade' ) )
            // InternalGames.g:5015:1: ( 'itemsMade' )
            {
            // InternalGames.g:5015:1: ( 'itemsMade' )
            // InternalGames.g:5016:2: 'itemsMade'
            {
             before(grammarAccess.getRecipeAccess().getItemsMadeKeyword_6()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getItemsMadeKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__6__Impl"


    // $ANTLR start "rule__Recipe__Group__7"
    // InternalGames.g:5025:1: rule__Recipe__Group__7 : rule__Recipe__Group__7__Impl rule__Recipe__Group__8 ;
    public final void rule__Recipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5029:1: ( rule__Recipe__Group__7__Impl rule__Recipe__Group__8 )
            // InternalGames.g:5030:2: rule__Recipe__Group__7__Impl rule__Recipe__Group__8
            {
            pushFollow(FOLLOW_46);
            rule__Recipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__7"


    // $ANTLR start "rule__Recipe__Group__7__Impl"
    // InternalGames.g:5037:1: rule__Recipe__Group__7__Impl : ( ( rule__Recipe__ItemsMadeAssignment_7 )* ) ;
    public final void rule__Recipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5041:1: ( ( ( rule__Recipe__ItemsMadeAssignment_7 )* ) )
            // InternalGames.g:5042:1: ( ( rule__Recipe__ItemsMadeAssignment_7 )* )
            {
            // InternalGames.g:5042:1: ( ( rule__Recipe__ItemsMadeAssignment_7 )* )
            // InternalGames.g:5043:2: ( rule__Recipe__ItemsMadeAssignment_7 )*
            {
             before(grammarAccess.getRecipeAccess().getItemsMadeAssignment_7()); 
            // InternalGames.g:5044:2: ( rule__Recipe__ItemsMadeAssignment_7 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalGames.g:5044:3: rule__Recipe__ItemsMadeAssignment_7
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Recipe__ItemsMadeAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getRecipeAccess().getItemsMadeAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__7__Impl"


    // $ANTLR start "rule__Recipe__Group__8"
    // InternalGames.g:5052:1: rule__Recipe__Group__8 : rule__Recipe__Group__8__Impl ;
    public final void rule__Recipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5056:1: ( rule__Recipe__Group__8__Impl )
            // InternalGames.g:5057:2: rule__Recipe__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Recipe__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__8"


    // $ANTLR start "rule__Recipe__Group__8__Impl"
    // InternalGames.g:5063:1: rule__Recipe__Group__8__Impl : ( '}' ) ;
    public final void rule__Recipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5067:1: ( ( '}' ) )
            // InternalGames.g:5068:1: ( '}' )
            {
            // InternalGames.g:5068:1: ( '}' )
            // InternalGames.g:5069:2: '}'
            {
             before(grammarAccess.getRecipeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group__8__Impl"


    // $ANTLR start "rule__Recipe__Group_5__0"
    // InternalGames.g:5079:1: rule__Recipe__Group_5__0 : rule__Recipe__Group_5__0__Impl rule__Recipe__Group_5__1 ;
    public final void rule__Recipe__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5083:1: ( rule__Recipe__Group_5__0__Impl rule__Recipe__Group_5__1 )
            // InternalGames.g:5084:2: rule__Recipe__Group_5__0__Impl rule__Recipe__Group_5__1
            {
            pushFollow(FOLLOW_32);
            rule__Recipe__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recipe__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group_5__0"


    // $ANTLR start "rule__Recipe__Group_5__0__Impl"
    // InternalGames.g:5091:1: rule__Recipe__Group_5__0__Impl : ( 'conditions' ) ;
    public final void rule__Recipe__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5095:1: ( ( 'conditions' ) )
            // InternalGames.g:5096:1: ( 'conditions' )
            {
            // InternalGames.g:5096:1: ( 'conditions' )
            // InternalGames.g:5097:2: 'conditions'
            {
             before(grammarAccess.getRecipeAccess().getConditionsKeyword_5_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getConditionsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group_5__0__Impl"


    // $ANTLR start "rule__Recipe__Group_5__1"
    // InternalGames.g:5106:1: rule__Recipe__Group_5__1 : rule__Recipe__Group_5__1__Impl ;
    public final void rule__Recipe__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5110:1: ( rule__Recipe__Group_5__1__Impl )
            // InternalGames.g:5111:2: rule__Recipe__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Recipe__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group_5__1"


    // $ANTLR start "rule__Recipe__Group_5__1__Impl"
    // InternalGames.g:5117:1: rule__Recipe__Group_5__1__Impl : ( ( rule__Recipe__ConditionsAssignment_5_1 )* ) ;
    public final void rule__Recipe__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5121:1: ( ( ( rule__Recipe__ConditionsAssignment_5_1 )* ) )
            // InternalGames.g:5122:1: ( ( rule__Recipe__ConditionsAssignment_5_1 )* )
            {
            // InternalGames.g:5122:1: ( ( rule__Recipe__ConditionsAssignment_5_1 )* )
            // InternalGames.g:5123:2: ( rule__Recipe__ConditionsAssignment_5_1 )*
            {
             before(grammarAccess.getRecipeAccess().getConditionsAssignment_5_1()); 
            // InternalGames.g:5124:2: ( rule__Recipe__ConditionsAssignment_5_1 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==59) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalGames.g:5124:3: rule__Recipe__ConditionsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Recipe__ConditionsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getRecipeAccess().getConditionsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__Group_5__1__Impl"


    // $ANTLR start "rule__Knowledge__Group__0"
    // InternalGames.g:5133:1: rule__Knowledge__Group__0 : rule__Knowledge__Group__0__Impl rule__Knowledge__Group__1 ;
    public final void rule__Knowledge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5137:1: ( rule__Knowledge__Group__0__Impl rule__Knowledge__Group__1 )
            // InternalGames.g:5138:2: rule__Knowledge__Group__0__Impl rule__Knowledge__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Knowledge__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__0"


    // $ANTLR start "rule__Knowledge__Group__0__Impl"
    // InternalGames.g:5145:1: rule__Knowledge__Group__0__Impl : ( 'knowledge' ) ;
    public final void rule__Knowledge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5149:1: ( ( 'knowledge' ) )
            // InternalGames.g:5150:1: ( 'knowledge' )
            {
            // InternalGames.g:5150:1: ( 'knowledge' )
            // InternalGames.g:5151:2: 'knowledge'
            {
             before(grammarAccess.getKnowledgeAccess().getKnowledgeKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getKnowledgeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__0__Impl"


    // $ANTLR start "rule__Knowledge__Group__1"
    // InternalGames.g:5160:1: rule__Knowledge__Group__1 : rule__Knowledge__Group__1__Impl rule__Knowledge__Group__2 ;
    public final void rule__Knowledge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5164:1: ( rule__Knowledge__Group__1__Impl rule__Knowledge__Group__2 )
            // InternalGames.g:5165:2: rule__Knowledge__Group__1__Impl rule__Knowledge__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Knowledge__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__1"


    // $ANTLR start "rule__Knowledge__Group__1__Impl"
    // InternalGames.g:5172:1: rule__Knowledge__Group__1__Impl : ( ( rule__Knowledge__NameAssignment_1 ) ) ;
    public final void rule__Knowledge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5176:1: ( ( ( rule__Knowledge__NameAssignment_1 ) ) )
            // InternalGames.g:5177:1: ( ( rule__Knowledge__NameAssignment_1 ) )
            {
            // InternalGames.g:5177:1: ( ( rule__Knowledge__NameAssignment_1 ) )
            // InternalGames.g:5178:2: ( rule__Knowledge__NameAssignment_1 )
            {
             before(grammarAccess.getKnowledgeAccess().getNameAssignment_1()); 
            // InternalGames.g:5179:2: ( rule__Knowledge__NameAssignment_1 )
            // InternalGames.g:5179:3: rule__Knowledge__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getKnowledgeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__1__Impl"


    // $ANTLR start "rule__Knowledge__Group__2"
    // InternalGames.g:5187:1: rule__Knowledge__Group__2 : rule__Knowledge__Group__2__Impl rule__Knowledge__Group__3 ;
    public final void rule__Knowledge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5191:1: ( rule__Knowledge__Group__2__Impl rule__Knowledge__Group__3 )
            // InternalGames.g:5192:2: rule__Knowledge__Group__2__Impl rule__Knowledge__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Knowledge__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__2"


    // $ANTLR start "rule__Knowledge__Group__2__Impl"
    // InternalGames.g:5199:1: rule__Knowledge__Group__2__Impl : ( '{' ) ;
    public final void rule__Knowledge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5203:1: ( ( '{' ) )
            // InternalGames.g:5204:1: ( '{' )
            {
            // InternalGames.g:5204:1: ( '{' )
            // InternalGames.g:5205:2: '{'
            {
             before(grammarAccess.getKnowledgeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__2__Impl"


    // $ANTLR start "rule__Knowledge__Group__3"
    // InternalGames.g:5214:1: rule__Knowledge__Group__3 : rule__Knowledge__Group__3__Impl rule__Knowledge__Group__4 ;
    public final void rule__Knowledge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5218:1: ( rule__Knowledge__Group__3__Impl rule__Knowledge__Group__4 )
            // InternalGames.g:5219:2: rule__Knowledge__Group__3__Impl rule__Knowledge__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__Knowledge__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__3"


    // $ANTLR start "rule__Knowledge__Group__3__Impl"
    // InternalGames.g:5226:1: rule__Knowledge__Group__3__Impl : ( 'description' ) ;
    public final void rule__Knowledge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5230:1: ( ( 'description' ) )
            // InternalGames.g:5231:1: ( 'description' )
            {
            // InternalGames.g:5231:1: ( 'description' )
            // InternalGames.g:5232:2: 'description'
            {
             before(grammarAccess.getKnowledgeAccess().getDescriptionKeyword_3()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getDescriptionKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__3__Impl"


    // $ANTLR start "rule__Knowledge__Group__4"
    // InternalGames.g:5241:1: rule__Knowledge__Group__4 : rule__Knowledge__Group__4__Impl rule__Knowledge__Group__5 ;
    public final void rule__Knowledge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5245:1: ( rule__Knowledge__Group__4__Impl rule__Knowledge__Group__5 )
            // InternalGames.g:5246:2: rule__Knowledge__Group__4__Impl rule__Knowledge__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__Knowledge__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__4"


    // $ANTLR start "rule__Knowledge__Group__4__Impl"
    // InternalGames.g:5253:1: rule__Knowledge__Group__4__Impl : ( ( rule__Knowledge__DescriptionAssignment_4 ) ) ;
    public final void rule__Knowledge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5257:1: ( ( ( rule__Knowledge__DescriptionAssignment_4 ) ) )
            // InternalGames.g:5258:1: ( ( rule__Knowledge__DescriptionAssignment_4 ) )
            {
            // InternalGames.g:5258:1: ( ( rule__Knowledge__DescriptionAssignment_4 ) )
            // InternalGames.g:5259:2: ( rule__Knowledge__DescriptionAssignment_4 )
            {
             before(grammarAccess.getKnowledgeAccess().getDescriptionAssignment_4()); 
            // InternalGames.g:5260:2: ( rule__Knowledge__DescriptionAssignment_4 )
            // InternalGames.g:5260:3: rule__Knowledge__DescriptionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__DescriptionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getKnowledgeAccess().getDescriptionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__4__Impl"


    // $ANTLR start "rule__Knowledge__Group__5"
    // InternalGames.g:5268:1: rule__Knowledge__Group__5 : rule__Knowledge__Group__5__Impl rule__Knowledge__Group__6 ;
    public final void rule__Knowledge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5272:1: ( rule__Knowledge__Group__5__Impl rule__Knowledge__Group__6 )
            // InternalGames.g:5273:2: rule__Knowledge__Group__5__Impl rule__Knowledge__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__Knowledge__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__5"


    // $ANTLR start "rule__Knowledge__Group__5__Impl"
    // InternalGames.g:5280:1: rule__Knowledge__Group__5__Impl : ( 'visible' ) ;
    public final void rule__Knowledge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5284:1: ( ( 'visible' ) )
            // InternalGames.g:5285:1: ( 'visible' )
            {
            // InternalGames.g:5285:1: ( 'visible' )
            // InternalGames.g:5286:2: 'visible'
            {
             before(grammarAccess.getKnowledgeAccess().getVisibleKeyword_5()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getVisibleKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__5__Impl"


    // $ANTLR start "rule__Knowledge__Group__6"
    // InternalGames.g:5295:1: rule__Knowledge__Group__6 : rule__Knowledge__Group__6__Impl rule__Knowledge__Group__7 ;
    public final void rule__Knowledge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5299:1: ( rule__Knowledge__Group__6__Impl rule__Knowledge__Group__7 )
            // InternalGames.g:5300:2: rule__Knowledge__Group__6__Impl rule__Knowledge__Group__7
            {
            pushFollow(FOLLOW_29);
            rule__Knowledge__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__6"


    // $ANTLR start "rule__Knowledge__Group__6__Impl"
    // InternalGames.g:5307:1: rule__Knowledge__Group__6__Impl : ( ( rule__Knowledge__VisibleAssignment_6 ) ) ;
    public final void rule__Knowledge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5311:1: ( ( ( rule__Knowledge__VisibleAssignment_6 ) ) )
            // InternalGames.g:5312:1: ( ( rule__Knowledge__VisibleAssignment_6 ) )
            {
            // InternalGames.g:5312:1: ( ( rule__Knowledge__VisibleAssignment_6 ) )
            // InternalGames.g:5313:2: ( rule__Knowledge__VisibleAssignment_6 )
            {
             before(grammarAccess.getKnowledgeAccess().getVisibleAssignment_6()); 
            // InternalGames.g:5314:2: ( rule__Knowledge__VisibleAssignment_6 )
            // InternalGames.g:5314:3: rule__Knowledge__VisibleAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__VisibleAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getKnowledgeAccess().getVisibleAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__6__Impl"


    // $ANTLR start "rule__Knowledge__Group__7"
    // InternalGames.g:5322:1: rule__Knowledge__Group__7 : rule__Knowledge__Group__7__Impl rule__Knowledge__Group__8 ;
    public final void rule__Knowledge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5326:1: ( rule__Knowledge__Group__7__Impl rule__Knowledge__Group__8 )
            // InternalGames.g:5327:2: rule__Knowledge__Group__7__Impl rule__Knowledge__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__Knowledge__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__7"


    // $ANTLR start "rule__Knowledge__Group__7__Impl"
    // InternalGames.g:5334:1: rule__Knowledge__Group__7__Impl : ( ( rule__Knowledge__Group_7__0 )? ) ;
    public final void rule__Knowledge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5338:1: ( ( ( rule__Knowledge__Group_7__0 )? ) )
            // InternalGames.g:5339:1: ( ( rule__Knowledge__Group_7__0 )? )
            {
            // InternalGames.g:5339:1: ( ( rule__Knowledge__Group_7__0 )? )
            // InternalGames.g:5340:2: ( rule__Knowledge__Group_7__0 )?
            {
             before(grammarAccess.getKnowledgeAccess().getGroup_7()); 
            // InternalGames.g:5341:2: ( rule__Knowledge__Group_7__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==38) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalGames.g:5341:3: rule__Knowledge__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Knowledge__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getKnowledgeAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__7__Impl"


    // $ANTLR start "rule__Knowledge__Group__8"
    // InternalGames.g:5349:1: rule__Knowledge__Group__8 : rule__Knowledge__Group__8__Impl rule__Knowledge__Group__9 ;
    public final void rule__Knowledge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5353:1: ( rule__Knowledge__Group__8__Impl rule__Knowledge__Group__9 )
            // InternalGames.g:5354:2: rule__Knowledge__Group__8__Impl rule__Knowledge__Group__9
            {
            pushFollow(FOLLOW_22);
            rule__Knowledge__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__8"


    // $ANTLR start "rule__Knowledge__Group__8__Impl"
    // InternalGames.g:5361:1: rule__Knowledge__Group__8__Impl : ( 'active' ) ;
    public final void rule__Knowledge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5365:1: ( ( 'active' ) )
            // InternalGames.g:5366:1: ( 'active' )
            {
            // InternalGames.g:5366:1: ( 'active' )
            // InternalGames.g:5367:2: 'active'
            {
             before(grammarAccess.getKnowledgeAccess().getActiveKeyword_8()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getActiveKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__8__Impl"


    // $ANTLR start "rule__Knowledge__Group__9"
    // InternalGames.g:5376:1: rule__Knowledge__Group__9 : rule__Knowledge__Group__9__Impl rule__Knowledge__Group__10 ;
    public final void rule__Knowledge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5380:1: ( rule__Knowledge__Group__9__Impl rule__Knowledge__Group__10 )
            // InternalGames.g:5381:2: rule__Knowledge__Group__9__Impl rule__Knowledge__Group__10
            {
            pushFollow(FOLLOW_47);
            rule__Knowledge__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__9"


    // $ANTLR start "rule__Knowledge__Group__9__Impl"
    // InternalGames.g:5388:1: rule__Knowledge__Group__9__Impl : ( ( rule__Knowledge__ActiveAssignment_9 ) ) ;
    public final void rule__Knowledge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5392:1: ( ( ( rule__Knowledge__ActiveAssignment_9 ) ) )
            // InternalGames.g:5393:1: ( ( rule__Knowledge__ActiveAssignment_9 ) )
            {
            // InternalGames.g:5393:1: ( ( rule__Knowledge__ActiveAssignment_9 ) )
            // InternalGames.g:5394:2: ( rule__Knowledge__ActiveAssignment_9 )
            {
             before(grammarAccess.getKnowledgeAccess().getActiveAssignment_9()); 
            // InternalGames.g:5395:2: ( rule__Knowledge__ActiveAssignment_9 )
            // InternalGames.g:5395:3: rule__Knowledge__ActiveAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__ActiveAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getKnowledgeAccess().getActiveAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__9__Impl"


    // $ANTLR start "rule__Knowledge__Group__10"
    // InternalGames.g:5403:1: rule__Knowledge__Group__10 : rule__Knowledge__Group__10__Impl rule__Knowledge__Group__11 ;
    public final void rule__Knowledge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5407:1: ( rule__Knowledge__Group__10__Impl rule__Knowledge__Group__11 )
            // InternalGames.g:5408:2: rule__Knowledge__Group__10__Impl rule__Knowledge__Group__11
            {
            pushFollow(FOLLOW_47);
            rule__Knowledge__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__10"


    // $ANTLR start "rule__Knowledge__Group__10__Impl"
    // InternalGames.g:5415:1: rule__Knowledge__Group__10__Impl : ( ( rule__Knowledge__Group_10__0 )? ) ;
    public final void rule__Knowledge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5419:1: ( ( ( rule__Knowledge__Group_10__0 )? ) )
            // InternalGames.g:5420:1: ( ( rule__Knowledge__Group_10__0 )? )
            {
            // InternalGames.g:5420:1: ( ( rule__Knowledge__Group_10__0 )? )
            // InternalGames.g:5421:2: ( rule__Knowledge__Group_10__0 )?
            {
             before(grammarAccess.getKnowledgeAccess().getGroup_10()); 
            // InternalGames.g:5422:2: ( rule__Knowledge__Group_10__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==39) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalGames.g:5422:3: rule__Knowledge__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Knowledge__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getKnowledgeAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__10__Impl"


    // $ANTLR start "rule__Knowledge__Group__11"
    // InternalGames.g:5430:1: rule__Knowledge__Group__11 : rule__Knowledge__Group__11__Impl rule__Knowledge__Group__12 ;
    public final void rule__Knowledge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5434:1: ( rule__Knowledge__Group__11__Impl rule__Knowledge__Group__12 )
            // InternalGames.g:5435:2: rule__Knowledge__Group__11__Impl rule__Knowledge__Group__12
            {
            pushFollow(FOLLOW_47);
            rule__Knowledge__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__11"


    // $ANTLR start "rule__Knowledge__Group__11__Impl"
    // InternalGames.g:5442:1: rule__Knowledge__Group__11__Impl : ( ( rule__Knowledge__Group_11__0 )? ) ;
    public final void rule__Knowledge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5446:1: ( ( ( rule__Knowledge__Group_11__0 )? ) )
            // InternalGames.g:5447:1: ( ( rule__Knowledge__Group_11__0 )? )
            {
            // InternalGames.g:5447:1: ( ( rule__Knowledge__Group_11__0 )? )
            // InternalGames.g:5448:2: ( rule__Knowledge__Group_11__0 )?
            {
             before(grammarAccess.getKnowledgeAccess().getGroup_11()); 
            // InternalGames.g:5449:2: ( rule__Knowledge__Group_11__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==49) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalGames.g:5449:3: rule__Knowledge__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Knowledge__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getKnowledgeAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__11__Impl"


    // $ANTLR start "rule__Knowledge__Group__12"
    // InternalGames.g:5457:1: rule__Knowledge__Group__12 : rule__Knowledge__Group__12__Impl ;
    public final void rule__Knowledge__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5461:1: ( rule__Knowledge__Group__12__Impl )
            // InternalGames.g:5462:2: rule__Knowledge__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__12"


    // $ANTLR start "rule__Knowledge__Group__12__Impl"
    // InternalGames.g:5468:1: rule__Knowledge__Group__12__Impl : ( '}' ) ;
    public final void rule__Knowledge__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5472:1: ( ( '}' ) )
            // InternalGames.g:5473:1: ( '}' )
            {
            // InternalGames.g:5473:1: ( '}' )
            // InternalGames.g:5474:2: '}'
            {
             before(grammarAccess.getKnowledgeAccess().getRightCurlyBracketKeyword_12()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group__12__Impl"


    // $ANTLR start "rule__Knowledge__Group_7__0"
    // InternalGames.g:5484:1: rule__Knowledge__Group_7__0 : rule__Knowledge__Group_7__0__Impl rule__Knowledge__Group_7__1 ;
    public final void rule__Knowledge__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5488:1: ( rule__Knowledge__Group_7__0__Impl rule__Knowledge__Group_7__1 )
            // InternalGames.g:5489:2: rule__Knowledge__Group_7__0__Impl rule__Knowledge__Group_7__1
            {
            pushFollow(FOLLOW_32);
            rule__Knowledge__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_7__0"


    // $ANTLR start "rule__Knowledge__Group_7__0__Impl"
    // InternalGames.g:5496:1: rule__Knowledge__Group_7__0__Impl : ( 'conditionsVisible' ) ;
    public final void rule__Knowledge__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5500:1: ( ( 'conditionsVisible' ) )
            // InternalGames.g:5501:1: ( 'conditionsVisible' )
            {
            // InternalGames.g:5501:1: ( 'conditionsVisible' )
            // InternalGames.g:5502:2: 'conditionsVisible'
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsVisibleKeyword_7_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getConditionsVisibleKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_7__0__Impl"


    // $ANTLR start "rule__Knowledge__Group_7__1"
    // InternalGames.g:5511:1: rule__Knowledge__Group_7__1 : rule__Knowledge__Group_7__1__Impl ;
    public final void rule__Knowledge__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5515:1: ( rule__Knowledge__Group_7__1__Impl )
            // InternalGames.g:5516:2: rule__Knowledge__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_7__1"


    // $ANTLR start "rule__Knowledge__Group_7__1__Impl"
    // InternalGames.g:5522:1: rule__Knowledge__Group_7__1__Impl : ( ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )* ) ;
    public final void rule__Knowledge__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5526:1: ( ( ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )* ) )
            // InternalGames.g:5527:1: ( ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )* )
            {
            // InternalGames.g:5527:1: ( ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )* )
            // InternalGames.g:5528:2: ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )*
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsVisibleAssignment_7_1()); 
            // InternalGames.g:5529:2: ( rule__Knowledge__ConditionsVisibleAssignment_7_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==59) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalGames.g:5529:3: rule__Knowledge__ConditionsVisibleAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Knowledge__ConditionsVisibleAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getKnowledgeAccess().getConditionsVisibleAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_7__1__Impl"


    // $ANTLR start "rule__Knowledge__Group_10__0"
    // InternalGames.g:5538:1: rule__Knowledge__Group_10__0 : rule__Knowledge__Group_10__0__Impl rule__Knowledge__Group_10__1 ;
    public final void rule__Knowledge__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5542:1: ( rule__Knowledge__Group_10__0__Impl rule__Knowledge__Group_10__1 )
            // InternalGames.g:5543:2: rule__Knowledge__Group_10__0__Impl rule__Knowledge__Group_10__1
            {
            pushFollow(FOLLOW_32);
            rule__Knowledge__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_10__0"


    // $ANTLR start "rule__Knowledge__Group_10__0__Impl"
    // InternalGames.g:5550:1: rule__Knowledge__Group_10__0__Impl : ( 'conditionsActive' ) ;
    public final void rule__Knowledge__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5554:1: ( ( 'conditionsActive' ) )
            // InternalGames.g:5555:1: ( 'conditionsActive' )
            {
            // InternalGames.g:5555:1: ( 'conditionsActive' )
            // InternalGames.g:5556:2: 'conditionsActive'
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsActiveKeyword_10_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getConditionsActiveKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_10__0__Impl"


    // $ANTLR start "rule__Knowledge__Group_10__1"
    // InternalGames.g:5565:1: rule__Knowledge__Group_10__1 : rule__Knowledge__Group_10__1__Impl ;
    public final void rule__Knowledge__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5569:1: ( rule__Knowledge__Group_10__1__Impl )
            // InternalGames.g:5570:2: rule__Knowledge__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_10__1"


    // $ANTLR start "rule__Knowledge__Group_10__1__Impl"
    // InternalGames.g:5576:1: rule__Knowledge__Group_10__1__Impl : ( ( rule__Knowledge__ConditionsActiveAssignment_10_1 )* ) ;
    public final void rule__Knowledge__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5580:1: ( ( ( rule__Knowledge__ConditionsActiveAssignment_10_1 )* ) )
            // InternalGames.g:5581:1: ( ( rule__Knowledge__ConditionsActiveAssignment_10_1 )* )
            {
            // InternalGames.g:5581:1: ( ( rule__Knowledge__ConditionsActiveAssignment_10_1 )* )
            // InternalGames.g:5582:2: ( rule__Knowledge__ConditionsActiveAssignment_10_1 )*
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsActiveAssignment_10_1()); 
            // InternalGames.g:5583:2: ( rule__Knowledge__ConditionsActiveAssignment_10_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==59) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalGames.g:5583:3: rule__Knowledge__ConditionsActiveAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Knowledge__ConditionsActiveAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getKnowledgeAccess().getConditionsActiveAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_10__1__Impl"


    // $ANTLR start "rule__Knowledge__Group_11__0"
    // InternalGames.g:5592:1: rule__Knowledge__Group_11__0 : rule__Knowledge__Group_11__0__Impl rule__Knowledge__Group_11__1 ;
    public final void rule__Knowledge__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5596:1: ( rule__Knowledge__Group_11__0__Impl rule__Knowledge__Group_11__1 )
            // InternalGames.g:5597:2: rule__Knowledge__Group_11__0__Impl rule__Knowledge__Group_11__1
            {
            pushFollow(FOLLOW_32);
            rule__Knowledge__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_11__0"


    // $ANTLR start "rule__Knowledge__Group_11__0__Impl"
    // InternalGames.g:5604:1: rule__Knowledge__Group_11__0__Impl : ( 'conditionsGive' ) ;
    public final void rule__Knowledge__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5608:1: ( ( 'conditionsGive' ) )
            // InternalGames.g:5609:1: ( 'conditionsGive' )
            {
            // InternalGames.g:5609:1: ( 'conditionsGive' )
            // InternalGames.g:5610:2: 'conditionsGive'
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsGiveKeyword_11_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getConditionsGiveKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_11__0__Impl"


    // $ANTLR start "rule__Knowledge__Group_11__1"
    // InternalGames.g:5619:1: rule__Knowledge__Group_11__1 : rule__Knowledge__Group_11__1__Impl ;
    public final void rule__Knowledge__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5623:1: ( rule__Knowledge__Group_11__1__Impl )
            // InternalGames.g:5624:2: rule__Knowledge__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Knowledge__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_11__1"


    // $ANTLR start "rule__Knowledge__Group_11__1__Impl"
    // InternalGames.g:5630:1: rule__Knowledge__Group_11__1__Impl : ( ( rule__Knowledge__ConditionsGiveAssignment_11_1 )* ) ;
    public final void rule__Knowledge__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5634:1: ( ( ( rule__Knowledge__ConditionsGiveAssignment_11_1 )* ) )
            // InternalGames.g:5635:1: ( ( rule__Knowledge__ConditionsGiveAssignment_11_1 )* )
            {
            // InternalGames.g:5635:1: ( ( rule__Knowledge__ConditionsGiveAssignment_11_1 )* )
            // InternalGames.g:5636:2: ( rule__Knowledge__ConditionsGiveAssignment_11_1 )*
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsGiveAssignment_11_1()); 
            // InternalGames.g:5637:2: ( rule__Knowledge__ConditionsGiveAssignment_11_1 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==59) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalGames.g:5637:3: rule__Knowledge__ConditionsGiveAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Knowledge__ConditionsGiveAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getKnowledgeAccess().getConditionsGiveAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__Group_11__1__Impl"


    // $ANTLR start "rule__Place__Group__0"
    // InternalGames.g:5646:1: rule__Place__Group__0 : rule__Place__Group__0__Impl rule__Place__Group__1 ;
    public final void rule__Place__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5650:1: ( rule__Place__Group__0__Impl rule__Place__Group__1 )
            // InternalGames.g:5651:2: rule__Place__Group__0__Impl rule__Place__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Place__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__0"


    // $ANTLR start "rule__Place__Group__0__Impl"
    // InternalGames.g:5658:1: rule__Place__Group__0__Impl : ( 'place' ) ;
    public final void rule__Place__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5662:1: ( ( 'place' ) )
            // InternalGames.g:5663:1: ( 'place' )
            {
            // InternalGames.g:5663:1: ( 'place' )
            // InternalGames.g:5664:2: 'place'
            {
             before(grammarAccess.getPlaceAccess().getPlaceKeyword_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getPlaceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__0__Impl"


    // $ANTLR start "rule__Place__Group__1"
    // InternalGames.g:5673:1: rule__Place__Group__1 : rule__Place__Group__1__Impl rule__Place__Group__2 ;
    public final void rule__Place__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5677:1: ( rule__Place__Group__1__Impl rule__Place__Group__2 )
            // InternalGames.g:5678:2: rule__Place__Group__1__Impl rule__Place__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Place__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__1"


    // $ANTLR start "rule__Place__Group__1__Impl"
    // InternalGames.g:5685:1: rule__Place__Group__1__Impl : ( ( rule__Place__NameAssignment_1 ) ) ;
    public final void rule__Place__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5689:1: ( ( ( rule__Place__NameAssignment_1 ) ) )
            // InternalGames.g:5690:1: ( ( rule__Place__NameAssignment_1 ) )
            {
            // InternalGames.g:5690:1: ( ( rule__Place__NameAssignment_1 ) )
            // InternalGames.g:5691:2: ( rule__Place__NameAssignment_1 )
            {
             before(grammarAccess.getPlaceAccess().getNameAssignment_1()); 
            // InternalGames.g:5692:2: ( rule__Place__NameAssignment_1 )
            // InternalGames.g:5692:3: rule__Place__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Place__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPlaceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__1__Impl"


    // $ANTLR start "rule__Place__Group__2"
    // InternalGames.g:5700:1: rule__Place__Group__2 : rule__Place__Group__2__Impl rule__Place__Group__3 ;
    public final void rule__Place__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5704:1: ( rule__Place__Group__2__Impl rule__Place__Group__3 )
            // InternalGames.g:5705:2: rule__Place__Group__2__Impl rule__Place__Group__3
            {
            pushFollow(FOLLOW_48);
            rule__Place__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__2"


    // $ANTLR start "rule__Place__Group__2__Impl"
    // InternalGames.g:5712:1: rule__Place__Group__2__Impl : ( '{' ) ;
    public final void rule__Place__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5716:1: ( ( '{' ) )
            // InternalGames.g:5717:1: ( '{' )
            {
            // InternalGames.g:5717:1: ( '{' )
            // InternalGames.g:5718:2: '{'
            {
             before(grammarAccess.getPlaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__2__Impl"


    // $ANTLR start "rule__Place__Group__3"
    // InternalGames.g:5727:1: rule__Place__Group__3 : rule__Place__Group__3__Impl rule__Place__Group__4 ;
    public final void rule__Place__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5731:1: ( rule__Place__Group__3__Impl rule__Place__Group__4 )
            // InternalGames.g:5732:2: rule__Place__Group__3__Impl rule__Place__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__Place__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__3"


    // $ANTLR start "rule__Place__Group__3__Impl"
    // InternalGames.g:5739:1: rule__Place__Group__3__Impl : ( ( rule__Place__Group_3__0 )? ) ;
    public final void rule__Place__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5743:1: ( ( ( rule__Place__Group_3__0 )? ) )
            // InternalGames.g:5744:1: ( ( rule__Place__Group_3__0 )? )
            {
            // InternalGames.g:5744:1: ( ( rule__Place__Group_3__0 )? )
            // InternalGames.g:5745:2: ( rule__Place__Group_3__0 )?
            {
             before(grammarAccess.getPlaceAccess().getGroup_3()); 
            // InternalGames.g:5746:2: ( rule__Place__Group_3__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==26) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalGames.g:5746:3: rule__Place__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Place__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlaceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__3__Impl"


    // $ANTLR start "rule__Place__Group__4"
    // InternalGames.g:5754:1: rule__Place__Group__4 : rule__Place__Group__4__Impl rule__Place__Group__5 ;
    public final void rule__Place__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5758:1: ( rule__Place__Group__4__Impl rule__Place__Group__5 )
            // InternalGames.g:5759:2: rule__Place__Group__4__Impl rule__Place__Group__5
            {
            pushFollow(FOLLOW_48);
            rule__Place__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__4"


    // $ANTLR start "rule__Place__Group__4__Impl"
    // InternalGames.g:5766:1: rule__Place__Group__4__Impl : ( ( rule__Place__Group_4__0 )? ) ;
    public final void rule__Place__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5770:1: ( ( ( rule__Place__Group_4__0 )? ) )
            // InternalGames.g:5771:1: ( ( rule__Place__Group_4__0 )? )
            {
            // InternalGames.g:5771:1: ( ( rule__Place__Group_4__0 )? )
            // InternalGames.g:5772:2: ( rule__Place__Group_4__0 )?
            {
             before(grammarAccess.getPlaceAccess().getGroup_4()); 
            // InternalGames.g:5773:2: ( rule__Place__Group_4__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==21) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalGames.g:5773:3: rule__Place__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Place__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlaceAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__4__Impl"


    // $ANTLR start "rule__Place__Group__5"
    // InternalGames.g:5781:1: rule__Place__Group__5 : rule__Place__Group__5__Impl rule__Place__Group__6 ;
    public final void rule__Place__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5785:1: ( rule__Place__Group__5__Impl rule__Place__Group__6 )
            // InternalGames.g:5786:2: rule__Place__Group__5__Impl rule__Place__Group__6
            {
            pushFollow(FOLLOW_48);
            rule__Place__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__5"


    // $ANTLR start "rule__Place__Group__5__Impl"
    // InternalGames.g:5793:1: rule__Place__Group__5__Impl : ( ( rule__Place__Group_5__0 )? ) ;
    public final void rule__Place__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5797:1: ( ( ( rule__Place__Group_5__0 )? ) )
            // InternalGames.g:5798:1: ( ( rule__Place__Group_5__0 )? )
            {
            // InternalGames.g:5798:1: ( ( rule__Place__Group_5__0 )? )
            // InternalGames.g:5799:2: ( rule__Place__Group_5__0 )?
            {
             before(grammarAccess.getPlaceAccess().getGroup_5()); 
            // InternalGames.g:5800:2: ( rule__Place__Group_5__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==58) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalGames.g:5800:3: rule__Place__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Place__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlaceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__5__Impl"


    // $ANTLR start "rule__Place__Group__6"
    // InternalGames.g:5808:1: rule__Place__Group__6 : rule__Place__Group__6__Impl rule__Place__Group__7 ;
    public final void rule__Place__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5812:1: ( rule__Place__Group__6__Impl rule__Place__Group__7 )
            // InternalGames.g:5813:2: rule__Place__Group__6__Impl rule__Place__Group__7
            {
            pushFollow(FOLLOW_48);
            rule__Place__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__6"


    // $ANTLR start "rule__Place__Group__6__Impl"
    // InternalGames.g:5820:1: rule__Place__Group__6__Impl : ( ( rule__Place__Group_6__0 )? ) ;
    public final void rule__Place__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5824:1: ( ( ( rule__Place__Group_6__0 )? ) )
            // InternalGames.g:5825:1: ( ( rule__Place__Group_6__0 )? )
            {
            // InternalGames.g:5825:1: ( ( rule__Place__Group_6__0 )? )
            // InternalGames.g:5826:2: ( rule__Place__Group_6__0 )?
            {
             before(grammarAccess.getPlaceAccess().getGroup_6()); 
            // InternalGames.g:5827:2: ( rule__Place__Group_6__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==27) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalGames.g:5827:3: rule__Place__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Place__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPlaceAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__6__Impl"


    // $ANTLR start "rule__Place__Group__7"
    // InternalGames.g:5835:1: rule__Place__Group__7 : rule__Place__Group__7__Impl ;
    public final void rule__Place__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5839:1: ( rule__Place__Group__7__Impl )
            // InternalGames.g:5840:2: rule__Place__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__7"


    // $ANTLR start "rule__Place__Group__7__Impl"
    // InternalGames.g:5846:1: rule__Place__Group__7__Impl : ( '}' ) ;
    public final void rule__Place__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5850:1: ( ( '}' ) )
            // InternalGames.g:5851:1: ( '}' )
            {
            // InternalGames.g:5851:1: ( '}' )
            // InternalGames.g:5852:2: '}'
            {
             before(grammarAccess.getPlaceAccess().getRightCurlyBracketKeyword_7()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group__7__Impl"


    // $ANTLR start "rule__Place__Group_3__0"
    // InternalGames.g:5862:1: rule__Place__Group_3__0 : rule__Place__Group_3__0__Impl rule__Place__Group_3__1 ;
    public final void rule__Place__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5866:1: ( rule__Place__Group_3__0__Impl rule__Place__Group_3__1 )
            // InternalGames.g:5867:2: rule__Place__Group_3__0__Impl rule__Place__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Place__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_3__0"


    // $ANTLR start "rule__Place__Group_3__0__Impl"
    // InternalGames.g:5874:1: rule__Place__Group_3__0__Impl : ( 'knowledge' ) ;
    public final void rule__Place__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5878:1: ( ( 'knowledge' ) )
            // InternalGames.g:5879:1: ( 'knowledge' )
            {
            // InternalGames.g:5879:1: ( 'knowledge' )
            // InternalGames.g:5880:2: 'knowledge'
            {
             before(grammarAccess.getPlaceAccess().getKnowledgeKeyword_3_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getKnowledgeKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_3__0__Impl"


    // $ANTLR start "rule__Place__Group_3__1"
    // InternalGames.g:5889:1: rule__Place__Group_3__1 : rule__Place__Group_3__1__Impl ;
    public final void rule__Place__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5893:1: ( rule__Place__Group_3__1__Impl )
            // InternalGames.g:5894:2: rule__Place__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_3__1"


    // $ANTLR start "rule__Place__Group_3__1__Impl"
    // InternalGames.g:5900:1: rule__Place__Group_3__1__Impl : ( ( rule__Place__KnowledgesAssignment_3_1 )* ) ;
    public final void rule__Place__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5904:1: ( ( ( rule__Place__KnowledgesAssignment_3_1 )* ) )
            // InternalGames.g:5905:1: ( ( rule__Place__KnowledgesAssignment_3_1 )* )
            {
            // InternalGames.g:5905:1: ( ( rule__Place__KnowledgesAssignment_3_1 )* )
            // InternalGames.g:5906:2: ( rule__Place__KnowledgesAssignment_3_1 )*
            {
             before(grammarAccess.getPlaceAccess().getKnowledgesAssignment_3_1()); 
            // InternalGames.g:5907:2: ( rule__Place__KnowledgesAssignment_3_1 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalGames.g:5907:3: rule__Place__KnowledgesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Place__KnowledgesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getPlaceAccess().getKnowledgesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_3__1__Impl"


    // $ANTLR start "rule__Place__Group_4__0"
    // InternalGames.g:5916:1: rule__Place__Group_4__0 : rule__Place__Group_4__0__Impl rule__Place__Group_4__1 ;
    public final void rule__Place__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5920:1: ( rule__Place__Group_4__0__Impl rule__Place__Group_4__1 )
            // InternalGames.g:5921:2: rule__Place__Group_4__0__Impl rule__Place__Group_4__1
            {
            pushFollow(FOLLOW_3);
            rule__Place__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_4__0"


    // $ANTLR start "rule__Place__Group_4__0__Impl"
    // InternalGames.g:5928:1: rule__Place__Group_4__0__Impl : ( 'people' ) ;
    public final void rule__Place__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5932:1: ( ( 'people' ) )
            // InternalGames.g:5933:1: ( 'people' )
            {
            // InternalGames.g:5933:1: ( 'people' )
            // InternalGames.g:5934:2: 'people'
            {
             before(grammarAccess.getPlaceAccess().getPeopleKeyword_4_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getPeopleKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_4__0__Impl"


    // $ANTLR start "rule__Place__Group_4__1"
    // InternalGames.g:5943:1: rule__Place__Group_4__1 : rule__Place__Group_4__1__Impl ;
    public final void rule__Place__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5947:1: ( rule__Place__Group_4__1__Impl )
            // InternalGames.g:5948:2: rule__Place__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_4__1"


    // $ANTLR start "rule__Place__Group_4__1__Impl"
    // InternalGames.g:5954:1: rule__Place__Group_4__1__Impl : ( ( rule__Place__PeopleAssignment_4_1 )* ) ;
    public final void rule__Place__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5958:1: ( ( ( rule__Place__PeopleAssignment_4_1 )* ) )
            // InternalGames.g:5959:1: ( ( rule__Place__PeopleAssignment_4_1 )* )
            {
            // InternalGames.g:5959:1: ( ( rule__Place__PeopleAssignment_4_1 )* )
            // InternalGames.g:5960:2: ( rule__Place__PeopleAssignment_4_1 )*
            {
             before(grammarAccess.getPlaceAccess().getPeopleAssignment_4_1()); 
            // InternalGames.g:5961:2: ( rule__Place__PeopleAssignment_4_1 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalGames.g:5961:3: rule__Place__PeopleAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Place__PeopleAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getPlaceAccess().getPeopleAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_4__1__Impl"


    // $ANTLR start "rule__Place__Group_5__0"
    // InternalGames.g:5970:1: rule__Place__Group_5__0 : rule__Place__Group_5__0__Impl rule__Place__Group_5__1 ;
    public final void rule__Place__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5974:1: ( rule__Place__Group_5__0__Impl rule__Place__Group_5__1 )
            // InternalGames.g:5975:2: rule__Place__Group_5__0__Impl rule__Place__Group_5__1
            {
            pushFollow(FOLLOW_3);
            rule__Place__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_5__0"


    // $ANTLR start "rule__Place__Group_5__0__Impl"
    // InternalGames.g:5982:1: rule__Place__Group_5__0__Impl : ( 'paths' ) ;
    public final void rule__Place__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:5986:1: ( ( 'paths' ) )
            // InternalGames.g:5987:1: ( 'paths' )
            {
            // InternalGames.g:5987:1: ( 'paths' )
            // InternalGames.g:5988:2: 'paths'
            {
             before(grammarAccess.getPlaceAccess().getPathsKeyword_5_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getPathsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_5__0__Impl"


    // $ANTLR start "rule__Place__Group_5__1"
    // InternalGames.g:5997:1: rule__Place__Group_5__1 : rule__Place__Group_5__1__Impl ;
    public final void rule__Place__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6001:1: ( rule__Place__Group_5__1__Impl )
            // InternalGames.g:6002:2: rule__Place__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_5__1"


    // $ANTLR start "rule__Place__Group_5__1__Impl"
    // InternalGames.g:6008:1: rule__Place__Group_5__1__Impl : ( ( rule__Place__PathsAssignment_5_1 )* ) ;
    public final void rule__Place__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6012:1: ( ( ( rule__Place__PathsAssignment_5_1 )* ) )
            // InternalGames.g:6013:1: ( ( rule__Place__PathsAssignment_5_1 )* )
            {
            // InternalGames.g:6013:1: ( ( rule__Place__PathsAssignment_5_1 )* )
            // InternalGames.g:6014:2: ( rule__Place__PathsAssignment_5_1 )*
            {
             before(grammarAccess.getPlaceAccess().getPathsAssignment_5_1()); 
            // InternalGames.g:6015:2: ( rule__Place__PathsAssignment_5_1 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalGames.g:6015:3: rule__Place__PathsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Place__PathsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getPlaceAccess().getPathsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_5__1__Impl"


    // $ANTLR start "rule__Place__Group_6__0"
    // InternalGames.g:6024:1: rule__Place__Group_6__0 : rule__Place__Group_6__0__Impl rule__Place__Group_6__1 ;
    public final void rule__Place__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6028:1: ( rule__Place__Group_6__0__Impl rule__Place__Group_6__1 )
            // InternalGames.g:6029:2: rule__Place__Group_6__0__Impl rule__Place__Group_6__1
            {
            pushFollow(FOLLOW_3);
            rule__Place__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Place__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_6__0"


    // $ANTLR start "rule__Place__Group_6__0__Impl"
    // InternalGames.g:6036:1: rule__Place__Group_6__0__Impl : ( 'items' ) ;
    public final void rule__Place__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6040:1: ( ( 'items' ) )
            // InternalGames.g:6041:1: ( 'items' )
            {
            // InternalGames.g:6041:1: ( 'items' )
            // InternalGames.g:6042:2: 'items'
            {
             before(grammarAccess.getPlaceAccess().getItemsKeyword_6_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getItemsKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_6__0__Impl"


    // $ANTLR start "rule__Place__Group_6__1"
    // InternalGames.g:6051:1: rule__Place__Group_6__1 : rule__Place__Group_6__1__Impl ;
    public final void rule__Place__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6055:1: ( rule__Place__Group_6__1__Impl )
            // InternalGames.g:6056:2: rule__Place__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Place__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_6__1"


    // $ANTLR start "rule__Place__Group_6__1__Impl"
    // InternalGames.g:6062:1: rule__Place__Group_6__1__Impl : ( ( rule__Place__ObjectsAssignment_6_1 )* ) ;
    public final void rule__Place__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6066:1: ( ( ( rule__Place__ObjectsAssignment_6_1 )* ) )
            // InternalGames.g:6067:1: ( ( rule__Place__ObjectsAssignment_6_1 )* )
            {
            // InternalGames.g:6067:1: ( ( rule__Place__ObjectsAssignment_6_1 )* )
            // InternalGames.g:6068:2: ( rule__Place__ObjectsAssignment_6_1 )*
            {
             before(grammarAccess.getPlaceAccess().getObjectsAssignment_6_1()); 
            // InternalGames.g:6069:2: ( rule__Place__ObjectsAssignment_6_1 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalGames.g:6069:3: rule__Place__ObjectsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Place__ObjectsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getPlaceAccess().getObjectsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__Group_6__1__Impl"


    // $ANTLR start "rule__ItemInCondition__Group__0"
    // InternalGames.g:6078:1: rule__ItemInCondition__Group__0 : rule__ItemInCondition__Group__0__Impl rule__ItemInCondition__Group__1 ;
    public final void rule__ItemInCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6082:1: ( rule__ItemInCondition__Group__0__Impl rule__ItemInCondition__Group__1 )
            // InternalGames.g:6083:2: rule__ItemInCondition__Group__0__Impl rule__ItemInCondition__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ItemInCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__0"


    // $ANTLR start "rule__ItemInCondition__Group__0__Impl"
    // InternalGames.g:6090:1: rule__ItemInCondition__Group__0__Impl : ( ( rule__ItemInCondition__ItemAssignment_0 ) ) ;
    public final void rule__ItemInCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6094:1: ( ( ( rule__ItemInCondition__ItemAssignment_0 ) ) )
            // InternalGames.g:6095:1: ( ( rule__ItemInCondition__ItemAssignment_0 ) )
            {
            // InternalGames.g:6095:1: ( ( rule__ItemInCondition__ItemAssignment_0 ) )
            // InternalGames.g:6096:2: ( rule__ItemInCondition__ItemAssignment_0 )
            {
             before(grammarAccess.getItemInConditionAccess().getItemAssignment_0()); 
            // InternalGames.g:6097:2: ( rule__ItemInCondition__ItemAssignment_0 )
            // InternalGames.g:6097:3: rule__ItemInCondition__ItemAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ItemInCondition__ItemAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getItemInConditionAccess().getItemAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__0__Impl"


    // $ANTLR start "rule__ItemInCondition__Group__1"
    // InternalGames.g:6105:1: rule__ItemInCondition__Group__1 : rule__ItemInCondition__Group__1__Impl rule__ItemInCondition__Group__2 ;
    public final void rule__ItemInCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6109:1: ( rule__ItemInCondition__Group__1__Impl rule__ItemInCondition__Group__2 )
            // InternalGames.g:6110:2: rule__ItemInCondition__Group__1__Impl rule__ItemInCondition__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__ItemInCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__1"


    // $ANTLR start "rule__ItemInCondition__Group__1__Impl"
    // InternalGames.g:6117:1: rule__ItemInCondition__Group__1__Impl : ( ':' ) ;
    public final void rule__ItemInCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6121:1: ( ( ':' ) )
            // InternalGames.g:6122:1: ( ':' )
            {
            // InternalGames.g:6122:1: ( ':' )
            // InternalGames.g:6123:2: ':'
            {
             before(grammarAccess.getItemInConditionAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getItemInConditionAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__1__Impl"


    // $ANTLR start "rule__ItemInCondition__Group__2"
    // InternalGames.g:6132:1: rule__ItemInCondition__Group__2 : rule__ItemInCondition__Group__2__Impl rule__ItemInCondition__Group__3 ;
    public final void rule__ItemInCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6136:1: ( rule__ItemInCondition__Group__2__Impl rule__ItemInCondition__Group__3 )
            // InternalGames.g:6137:2: rule__ItemInCondition__Group__2__Impl rule__ItemInCondition__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__ItemInCondition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__2"


    // $ANTLR start "rule__ItemInCondition__Group__2__Impl"
    // InternalGames.g:6144:1: rule__ItemInCondition__Group__2__Impl : ( ( rule__ItemInCondition__QuantityAssignment_2 ) ) ;
    public final void rule__ItemInCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6148:1: ( ( ( rule__ItemInCondition__QuantityAssignment_2 ) ) )
            // InternalGames.g:6149:1: ( ( rule__ItemInCondition__QuantityAssignment_2 ) )
            {
            // InternalGames.g:6149:1: ( ( rule__ItemInCondition__QuantityAssignment_2 ) )
            // InternalGames.g:6150:2: ( rule__ItemInCondition__QuantityAssignment_2 )
            {
             before(grammarAccess.getItemInConditionAccess().getQuantityAssignment_2()); 
            // InternalGames.g:6151:2: ( rule__ItemInCondition__QuantityAssignment_2 )
            // InternalGames.g:6151:3: rule__ItemInCondition__QuantityAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ItemInCondition__QuantityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getItemInConditionAccess().getQuantityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__2__Impl"


    // $ANTLR start "rule__ItemInCondition__Group__3"
    // InternalGames.g:6159:1: rule__ItemInCondition__Group__3 : rule__ItemInCondition__Group__3__Impl rule__ItemInCondition__Group__4 ;
    public final void rule__ItemInCondition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6163:1: ( rule__ItemInCondition__Group__3__Impl rule__ItemInCondition__Group__4 )
            // InternalGames.g:6164:2: rule__ItemInCondition__Group__3__Impl rule__ItemInCondition__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__ItemInCondition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__3"


    // $ANTLR start "rule__ItemInCondition__Group__3__Impl"
    // InternalGames.g:6171:1: rule__ItemInCondition__Group__3__Impl : ( ':' ) ;
    public final void rule__ItemInCondition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6175:1: ( ( ':' ) )
            // InternalGames.g:6176:1: ( ':' )
            {
            // InternalGames.g:6176:1: ( ':' )
            // InternalGames.g:6177:2: ':'
            {
             before(grammarAccess.getItemInConditionAccess().getColonKeyword_3()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getItemInConditionAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__3__Impl"


    // $ANTLR start "rule__ItemInCondition__Group__4"
    // InternalGames.g:6186:1: rule__ItemInCondition__Group__4 : rule__ItemInCondition__Group__4__Impl ;
    public final void rule__ItemInCondition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6190:1: ( rule__ItemInCondition__Group__4__Impl )
            // InternalGames.g:6191:2: rule__ItemInCondition__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ItemInCondition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__4"


    // $ANTLR start "rule__ItemInCondition__Group__4__Impl"
    // InternalGames.g:6197:1: rule__ItemInCondition__Group__4__Impl : ( ( rule__ItemInCondition__MustBeExactAssignment_4 ) ) ;
    public final void rule__ItemInCondition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6201:1: ( ( ( rule__ItemInCondition__MustBeExactAssignment_4 ) ) )
            // InternalGames.g:6202:1: ( ( rule__ItemInCondition__MustBeExactAssignment_4 ) )
            {
            // InternalGames.g:6202:1: ( ( rule__ItemInCondition__MustBeExactAssignment_4 ) )
            // InternalGames.g:6203:2: ( rule__ItemInCondition__MustBeExactAssignment_4 )
            {
             before(grammarAccess.getItemInConditionAccess().getMustBeExactAssignment_4()); 
            // InternalGames.g:6204:2: ( rule__ItemInCondition__MustBeExactAssignment_4 )
            // InternalGames.g:6204:3: rule__ItemInCondition__MustBeExactAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ItemInCondition__MustBeExactAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getItemInConditionAccess().getMustBeExactAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__Group__4__Impl"


    // $ANTLR start "rule__Condition__Group__0"
    // InternalGames.g:6213:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6217:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalGames.g:6218:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalGames.g:6225:1: rule__Condition__Group__0__Impl : ( 'condition' ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6229:1: ( ( 'condition' ) )
            // InternalGames.g:6230:1: ( 'condition' )
            {
            // InternalGames.g:6230:1: ( 'condition' )
            // InternalGames.g:6231:2: 'condition'
            {
             before(grammarAccess.getConditionAccess().getConditionKeyword_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConditionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalGames.g:6240:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl rule__Condition__Group__2 ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6244:1: ( rule__Condition__Group__1__Impl rule__Condition__Group__2 )
            // InternalGames.g:6245:2: rule__Condition__Group__1__Impl rule__Condition__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Condition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalGames.g:6252:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__NameAssignment_1 ) ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6256:1: ( ( ( rule__Condition__NameAssignment_1 ) ) )
            // InternalGames.g:6257:1: ( ( rule__Condition__NameAssignment_1 ) )
            {
            // InternalGames.g:6257:1: ( ( rule__Condition__NameAssignment_1 ) )
            // InternalGames.g:6258:2: ( rule__Condition__NameAssignment_1 )
            {
             before(grammarAccess.getConditionAccess().getNameAssignment_1()); 
            // InternalGames.g:6259:2: ( rule__Condition__NameAssignment_1 )
            // InternalGames.g:6259:3: rule__Condition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Condition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group__2"
    // InternalGames.g:6267:1: rule__Condition__Group__2 : rule__Condition__Group__2__Impl rule__Condition__Group__3 ;
    public final void rule__Condition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6271:1: ( rule__Condition__Group__2__Impl rule__Condition__Group__3 )
            // InternalGames.g:6272:2: rule__Condition__Group__2__Impl rule__Condition__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Condition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2"


    // $ANTLR start "rule__Condition__Group__2__Impl"
    // InternalGames.g:6279:1: rule__Condition__Group__2__Impl : ( '{' ) ;
    public final void rule__Condition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6283:1: ( ( '{' ) )
            // InternalGames.g:6284:1: ( '{' )
            {
            // InternalGames.g:6284:1: ( '{' )
            // InternalGames.g:6285:2: '{'
            {
             before(grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2__Impl"


    // $ANTLR start "rule__Condition__Group__3"
    // InternalGames.g:6294:1: rule__Condition__Group__3 : rule__Condition__Group__3__Impl rule__Condition__Group__4 ;
    public final void rule__Condition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6298:1: ( rule__Condition__Group__3__Impl rule__Condition__Group__4 )
            // InternalGames.g:6299:2: rule__Condition__Group__3__Impl rule__Condition__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Condition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__3"


    // $ANTLR start "rule__Condition__Group__3__Impl"
    // InternalGames.g:6306:1: rule__Condition__Group__3__Impl : ( 'player' ) ;
    public final void rule__Condition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6310:1: ( ( 'player' ) )
            // InternalGames.g:6311:1: ( 'player' )
            {
            // InternalGames.g:6311:1: ( 'player' )
            // InternalGames.g:6312:2: 'player'
            {
             before(grammarAccess.getConditionAccess().getPlayerKeyword_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getPlayerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__3__Impl"


    // $ANTLR start "rule__Condition__Group__4"
    // InternalGames.g:6321:1: rule__Condition__Group__4 : rule__Condition__Group__4__Impl rule__Condition__Group__5 ;
    public final void rule__Condition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6325:1: ( rule__Condition__Group__4__Impl rule__Condition__Group__5 )
            // InternalGames.g:6326:2: rule__Condition__Group__4__Impl rule__Condition__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Condition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__4"


    // $ANTLR start "rule__Condition__Group__4__Impl"
    // InternalGames.g:6333:1: rule__Condition__Group__4__Impl : ( ( rule__Condition__PlayerAssignment_4 ) ) ;
    public final void rule__Condition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6337:1: ( ( ( rule__Condition__PlayerAssignment_4 ) ) )
            // InternalGames.g:6338:1: ( ( rule__Condition__PlayerAssignment_4 ) )
            {
            // InternalGames.g:6338:1: ( ( rule__Condition__PlayerAssignment_4 ) )
            // InternalGames.g:6339:2: ( rule__Condition__PlayerAssignment_4 )
            {
             before(grammarAccess.getConditionAccess().getPlayerAssignment_4()); 
            // InternalGames.g:6340:2: ( rule__Condition__PlayerAssignment_4 )
            // InternalGames.g:6340:3: rule__Condition__PlayerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Condition__PlayerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getPlayerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__4__Impl"


    // $ANTLR start "rule__Condition__Group__5"
    // InternalGames.g:6348:1: rule__Condition__Group__5 : rule__Condition__Group__5__Impl rule__Condition__Group__6 ;
    public final void rule__Condition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6352:1: ( rule__Condition__Group__5__Impl rule__Condition__Group__6 )
            // InternalGames.g:6353:2: rule__Condition__Group__5__Impl rule__Condition__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__Condition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__5"


    // $ANTLR start "rule__Condition__Group__5__Impl"
    // InternalGames.g:6360:1: rule__Condition__Group__5__Impl : ( ( rule__Condition__Group_5__0 )? ) ;
    public final void rule__Condition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6364:1: ( ( ( rule__Condition__Group_5__0 )? ) )
            // InternalGames.g:6365:1: ( ( rule__Condition__Group_5__0 )? )
            {
            // InternalGames.g:6365:1: ( ( rule__Condition__Group_5__0 )? )
            // InternalGames.g:6366:2: ( rule__Condition__Group_5__0 )?
            {
             before(grammarAccess.getConditionAccess().getGroup_5()); 
            // InternalGames.g:6367:2: ( rule__Condition__Group_5__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==26) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalGames.g:6367:3: rule__Condition__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Condition__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__5__Impl"


    // $ANTLR start "rule__Condition__Group__6"
    // InternalGames.g:6375:1: rule__Condition__Group__6 : rule__Condition__Group__6__Impl rule__Condition__Group__7 ;
    public final void rule__Condition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6379:1: ( rule__Condition__Group__6__Impl rule__Condition__Group__7 )
            // InternalGames.g:6380:2: rule__Condition__Group__6__Impl rule__Condition__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__Condition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__6"


    // $ANTLR start "rule__Condition__Group__6__Impl"
    // InternalGames.g:6387:1: rule__Condition__Group__6__Impl : ( ( rule__Condition__Group_6__0 )? ) ;
    public final void rule__Condition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6391:1: ( ( ( rule__Condition__Group_6__0 )? ) )
            // InternalGames.g:6392:1: ( ( rule__Condition__Group_6__0 )? )
            {
            // InternalGames.g:6392:1: ( ( rule__Condition__Group_6__0 )? )
            // InternalGames.g:6393:2: ( rule__Condition__Group_6__0 )?
            {
             before(grammarAccess.getConditionAccess().getGroup_6()); 
            // InternalGames.g:6394:2: ( rule__Condition__Group_6__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==27) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalGames.g:6394:3: rule__Condition__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Condition__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__6__Impl"


    // $ANTLR start "rule__Condition__Group__7"
    // InternalGames.g:6402:1: rule__Condition__Group__7 : rule__Condition__Group__7__Impl ;
    public final void rule__Condition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6406:1: ( rule__Condition__Group__7__Impl )
            // InternalGames.g:6407:2: rule__Condition__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__7"


    // $ANTLR start "rule__Condition__Group__7__Impl"
    // InternalGames.g:6413:1: rule__Condition__Group__7__Impl : ( '}' ) ;
    public final void rule__Condition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6417:1: ( ( '}' ) )
            // InternalGames.g:6418:1: ( '}' )
            {
            // InternalGames.g:6418:1: ( '}' )
            // InternalGames.g:6419:2: '}'
            {
             before(grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_7()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__7__Impl"


    // $ANTLR start "rule__Condition__Group_5__0"
    // InternalGames.g:6429:1: rule__Condition__Group_5__0 : rule__Condition__Group_5__0__Impl rule__Condition__Group_5__1 ;
    public final void rule__Condition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6433:1: ( rule__Condition__Group_5__0__Impl rule__Condition__Group_5__1 )
            // InternalGames.g:6434:2: rule__Condition__Group_5__0__Impl rule__Condition__Group_5__1
            {
            pushFollow(FOLLOW_3);
            rule__Condition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_5__0"


    // $ANTLR start "rule__Condition__Group_5__0__Impl"
    // InternalGames.g:6441:1: rule__Condition__Group_5__0__Impl : ( 'knowledge' ) ;
    public final void rule__Condition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6445:1: ( ( 'knowledge' ) )
            // InternalGames.g:6446:1: ( 'knowledge' )
            {
            // InternalGames.g:6446:1: ( 'knowledge' )
            // InternalGames.g:6447:2: 'knowledge'
            {
             before(grammarAccess.getConditionAccess().getKnowledgeKeyword_5_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getKnowledgeKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_5__0__Impl"


    // $ANTLR start "rule__Condition__Group_5__1"
    // InternalGames.g:6456:1: rule__Condition__Group_5__1 : rule__Condition__Group_5__1__Impl ;
    public final void rule__Condition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6460:1: ( rule__Condition__Group_5__1__Impl )
            // InternalGames.g:6461:2: rule__Condition__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_5__1"


    // $ANTLR start "rule__Condition__Group_5__1__Impl"
    // InternalGames.g:6467:1: rule__Condition__Group_5__1__Impl : ( ( rule__Condition__KnowAssignment_5_1 )* ) ;
    public final void rule__Condition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6471:1: ( ( ( rule__Condition__KnowAssignment_5_1 )* ) )
            // InternalGames.g:6472:1: ( ( rule__Condition__KnowAssignment_5_1 )* )
            {
            // InternalGames.g:6472:1: ( ( rule__Condition__KnowAssignment_5_1 )* )
            // InternalGames.g:6473:2: ( rule__Condition__KnowAssignment_5_1 )*
            {
             before(grammarAccess.getConditionAccess().getKnowAssignment_5_1()); 
            // InternalGames.g:6474:2: ( rule__Condition__KnowAssignment_5_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalGames.g:6474:3: rule__Condition__KnowAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Condition__KnowAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getKnowAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_5__1__Impl"


    // $ANTLR start "rule__Condition__Group_6__0"
    // InternalGames.g:6483:1: rule__Condition__Group_6__0 : rule__Condition__Group_6__0__Impl rule__Condition__Group_6__1 ;
    public final void rule__Condition__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6487:1: ( rule__Condition__Group_6__0__Impl rule__Condition__Group_6__1 )
            // InternalGames.g:6488:2: rule__Condition__Group_6__0__Impl rule__Condition__Group_6__1
            {
            pushFollow(FOLLOW_3);
            rule__Condition__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_6__0"


    // $ANTLR start "rule__Condition__Group_6__0__Impl"
    // InternalGames.g:6495:1: rule__Condition__Group_6__0__Impl : ( 'items' ) ;
    public final void rule__Condition__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6499:1: ( ( 'items' ) )
            // InternalGames.g:6500:1: ( 'items' )
            {
            // InternalGames.g:6500:1: ( 'items' )
            // InternalGames.g:6501:2: 'items'
            {
             before(grammarAccess.getConditionAccess().getItemsKeyword_6_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getItemsKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_6__0__Impl"


    // $ANTLR start "rule__Condition__Group_6__1"
    // InternalGames.g:6510:1: rule__Condition__Group_6__1 : rule__Condition__Group_6__1__Impl ;
    public final void rule__Condition__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6514:1: ( rule__Condition__Group_6__1__Impl )
            // InternalGames.g:6515:2: rule__Condition__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_6__1"


    // $ANTLR start "rule__Condition__Group_6__1__Impl"
    // InternalGames.g:6521:1: rule__Condition__Group_6__1__Impl : ( ( rule__Condition__ItemAssignment_6_1 )* ) ;
    public final void rule__Condition__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6525:1: ( ( ( rule__Condition__ItemAssignment_6_1 )* ) )
            // InternalGames.g:6526:1: ( ( rule__Condition__ItemAssignment_6_1 )* )
            {
            // InternalGames.g:6526:1: ( ( rule__Condition__ItemAssignment_6_1 )* )
            // InternalGames.g:6527:2: ( rule__Condition__ItemAssignment_6_1 )*
            {
             before(grammarAccess.getConditionAccess().getItemAssignment_6_1()); 
            // InternalGames.g:6528:2: ( rule__Condition__ItemAssignment_6_1 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalGames.g:6528:3: rule__Condition__ItemAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Condition__ItemAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

             after(grammarAccess.getConditionAccess().getItemAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group_6__1__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalGames.g:6537:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6541:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalGames.g:6542:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalGames.g:6549:1: rule__Action__Group__0__Impl : ( 'action' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6553:1: ( ( 'action' ) )
            // InternalGames.g:6554:1: ( 'action' )
            {
            // InternalGames.g:6554:1: ( 'action' )
            // InternalGames.g:6555:2: 'action'
            {
             before(grammarAccess.getActionAccess().getActionKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getActionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalGames.g:6564:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6568:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalGames.g:6569:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalGames.g:6576:1: rule__Action__Group__1__Impl : ( ( rule__Action__NameAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6580:1: ( ( ( rule__Action__NameAssignment_1 ) ) )
            // InternalGames.g:6581:1: ( ( rule__Action__NameAssignment_1 ) )
            {
            // InternalGames.g:6581:1: ( ( rule__Action__NameAssignment_1 ) )
            // InternalGames.g:6582:2: ( rule__Action__NameAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getNameAssignment_1()); 
            // InternalGames.g:6583:2: ( rule__Action__NameAssignment_1 )
            // InternalGames.g:6583:3: rule__Action__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Action__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // InternalGames.g:6591:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6595:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalGames.g:6596:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FOLLOW_49);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // InternalGames.g:6603:1: rule__Action__Group__2__Impl : ( '{' ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6607:1: ( ( '{' ) )
            // InternalGames.g:6608:1: ( '{' )
            {
            // InternalGames.g:6608:1: ( '{' )
            // InternalGames.g:6609:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__3"
    // InternalGames.g:6618:1: rule__Action__Group__3 : rule__Action__Group__3__Impl rule__Action__Group__4 ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6622:1: ( rule__Action__Group__3__Impl rule__Action__Group__4 )
            // InternalGames.g:6623:2: rule__Action__Group__3__Impl rule__Action__Group__4
            {
            pushFollow(FOLLOW_50);
            rule__Action__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3"


    // $ANTLR start "rule__Action__Group__3__Impl"
    // InternalGames.g:6630:1: rule__Action__Group__3__Impl : ( 'value' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6634:1: ( ( 'value' ) )
            // InternalGames.g:6635:1: ( 'value' )
            {
            // InternalGames.g:6635:1: ( 'value' )
            // InternalGames.g:6636:2: 'value'
            {
             before(grammarAccess.getActionAccess().getValueKeyword_3()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getValueKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3__Impl"


    // $ANTLR start "rule__Action__Group__4"
    // InternalGames.g:6645:1: rule__Action__Group__4 : rule__Action__Group__4__Impl rule__Action__Group__5 ;
    public final void rule__Action__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6649:1: ( rule__Action__Group__4__Impl rule__Action__Group__5 )
            // InternalGames.g:6650:2: rule__Action__Group__4__Impl rule__Action__Group__5
            {
            pushFollow(FOLLOW_51);
            rule__Action__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__4"


    // $ANTLR start "rule__Action__Group__4__Impl"
    // InternalGames.g:6657:1: rule__Action__Group__4__Impl : ( ( rule__Action__ValAssignment_4 ) ) ;
    public final void rule__Action__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6661:1: ( ( ( rule__Action__ValAssignment_4 ) ) )
            // InternalGames.g:6662:1: ( ( rule__Action__ValAssignment_4 ) )
            {
            // InternalGames.g:6662:1: ( ( rule__Action__ValAssignment_4 ) )
            // InternalGames.g:6663:2: ( rule__Action__ValAssignment_4 )
            {
             before(grammarAccess.getActionAccess().getValAssignment_4()); 
            // InternalGames.g:6664:2: ( rule__Action__ValAssignment_4 )
            // InternalGames.g:6664:3: rule__Action__ValAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Action__ValAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getValAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__4__Impl"


    // $ANTLR start "rule__Action__Group__5"
    // InternalGames.g:6672:1: rule__Action__Group__5 : rule__Action__Group__5__Impl rule__Action__Group__6 ;
    public final void rule__Action__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6676:1: ( rule__Action__Group__5__Impl rule__Action__Group__6 )
            // InternalGames.g:6677:2: rule__Action__Group__5__Impl rule__Action__Group__6
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__5"


    // $ANTLR start "rule__Action__Group__5__Impl"
    // InternalGames.g:6684:1: rule__Action__Group__5__Impl : ( 'nextInteraction' ) ;
    public final void rule__Action__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6688:1: ( ( 'nextInteraction' ) )
            // InternalGames.g:6689:1: ( 'nextInteraction' )
            {
            // InternalGames.g:6689:1: ( 'nextInteraction' )
            // InternalGames.g:6690:2: 'nextInteraction'
            {
             before(grammarAccess.getActionAccess().getNextInteractionKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getNextInteractionKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__5__Impl"


    // $ANTLR start "rule__Action__Group__6"
    // InternalGames.g:6699:1: rule__Action__Group__6 : rule__Action__Group__6__Impl rule__Action__Group__7 ;
    public final void rule__Action__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6703:1: ( rule__Action__Group__6__Impl rule__Action__Group__7 )
            // InternalGames.g:6704:2: rule__Action__Group__6__Impl rule__Action__Group__7
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__6"


    // $ANTLR start "rule__Action__Group__6__Impl"
    // InternalGames.g:6711:1: rule__Action__Group__6__Impl : ( ( rule__Action__InterSuivanteAssignment_6 )? ) ;
    public final void rule__Action__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6715:1: ( ( ( rule__Action__InterSuivanteAssignment_6 )? ) )
            // InternalGames.g:6716:1: ( ( rule__Action__InterSuivanteAssignment_6 )? )
            {
            // InternalGames.g:6716:1: ( ( rule__Action__InterSuivanteAssignment_6 )? )
            // InternalGames.g:6717:2: ( rule__Action__InterSuivanteAssignment_6 )?
            {
             before(grammarAccess.getActionAccess().getInterSuivanteAssignment_6()); 
            // InternalGames.g:6718:2: ( rule__Action__InterSuivanteAssignment_6 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==65) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalGames.g:6718:3: rule__Action__InterSuivanteAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__InterSuivanteAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getInterSuivanteAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__6__Impl"


    // $ANTLR start "rule__Action__Group__7"
    // InternalGames.g:6726:1: rule__Action__Group__7 : rule__Action__Group__7__Impl rule__Action__Group__8 ;
    public final void rule__Action__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6730:1: ( rule__Action__Group__7__Impl rule__Action__Group__8 )
            // InternalGames.g:6731:2: rule__Action__Group__7__Impl rule__Action__Group__8
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__7"


    // $ANTLR start "rule__Action__Group__7__Impl"
    // InternalGames.g:6738:1: rule__Action__Group__7__Impl : ( ( rule__Action__Group_7__0 )? ) ;
    public final void rule__Action__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6742:1: ( ( ( rule__Action__Group_7__0 )? ) )
            // InternalGames.g:6743:1: ( ( rule__Action__Group_7__0 )? )
            {
            // InternalGames.g:6743:1: ( ( rule__Action__Group_7__0 )? )
            // InternalGames.g:6744:2: ( rule__Action__Group_7__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_7()); 
            // InternalGames.g:6745:2: ( rule__Action__Group_7__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==63) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalGames.g:6745:3: rule__Action__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__7__Impl"


    // $ANTLR start "rule__Action__Group__8"
    // InternalGames.g:6753:1: rule__Action__Group__8 : rule__Action__Group__8__Impl rule__Action__Group__9 ;
    public final void rule__Action__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6757:1: ( rule__Action__Group__8__Impl rule__Action__Group__9 )
            // InternalGames.g:6758:2: rule__Action__Group__8__Impl rule__Action__Group__9
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__8"


    // $ANTLR start "rule__Action__Group__8__Impl"
    // InternalGames.g:6765:1: rule__Action__Group__8__Impl : ( ( rule__Action__Group_8__0 )? ) ;
    public final void rule__Action__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6769:1: ( ( ( rule__Action__Group_8__0 )? ) )
            // InternalGames.g:6770:1: ( ( rule__Action__Group_8__0 )? )
            {
            // InternalGames.g:6770:1: ( ( rule__Action__Group_8__0 )? )
            // InternalGames.g:6771:2: ( rule__Action__Group_8__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_8()); 
            // InternalGames.g:6772:2: ( rule__Action__Group_8__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==43) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalGames.g:6772:3: rule__Action__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__8__Impl"


    // $ANTLR start "rule__Action__Group__9"
    // InternalGames.g:6780:1: rule__Action__Group__9 : rule__Action__Group__9__Impl rule__Action__Group__10 ;
    public final void rule__Action__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6784:1: ( rule__Action__Group__9__Impl rule__Action__Group__10 )
            // InternalGames.g:6785:2: rule__Action__Group__9__Impl rule__Action__Group__10
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__9"


    // $ANTLR start "rule__Action__Group__9__Impl"
    // InternalGames.g:6792:1: rule__Action__Group__9__Impl : ( ( rule__Action__Group_9__0 )? ) ;
    public final void rule__Action__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6796:1: ( ( ( rule__Action__Group_9__0 )? ) )
            // InternalGames.g:6797:1: ( ( rule__Action__Group_9__0 )? )
            {
            // InternalGames.g:6797:1: ( ( rule__Action__Group_9__0 )? )
            // InternalGames.g:6798:2: ( rule__Action__Group_9__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_9()); 
            // InternalGames.g:6799:2: ( rule__Action__Group_9__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==44) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalGames.g:6799:3: rule__Action__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__9__Impl"


    // $ANTLR start "rule__Action__Group__10"
    // InternalGames.g:6807:1: rule__Action__Group__10 : rule__Action__Group__10__Impl rule__Action__Group__11 ;
    public final void rule__Action__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6811:1: ( rule__Action__Group__10__Impl rule__Action__Group__11 )
            // InternalGames.g:6812:2: rule__Action__Group__10__Impl rule__Action__Group__11
            {
            pushFollow(FOLLOW_52);
            rule__Action__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__10"


    // $ANTLR start "rule__Action__Group__10__Impl"
    // InternalGames.g:6819:1: rule__Action__Group__10__Impl : ( ( rule__Action__Group_10__0 )? ) ;
    public final void rule__Action__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6823:1: ( ( ( rule__Action__Group_10__0 )? ) )
            // InternalGames.g:6824:1: ( ( rule__Action__Group_10__0 )? )
            {
            // InternalGames.g:6824:1: ( ( rule__Action__Group_10__0 )? )
            // InternalGames.g:6825:2: ( rule__Action__Group_10__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_10()); 
            // InternalGames.g:6826:2: ( rule__Action__Group_10__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==64) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalGames.g:6826:3: rule__Action__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__10__Impl"


    // $ANTLR start "rule__Action__Group__11"
    // InternalGames.g:6834:1: rule__Action__Group__11 : rule__Action__Group__11__Impl rule__Action__Group__12 ;
    public final void rule__Action__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6838:1: ( rule__Action__Group__11__Impl rule__Action__Group__12 )
            // InternalGames.g:6839:2: rule__Action__Group__11__Impl rule__Action__Group__12
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__11"


    // $ANTLR start "rule__Action__Group__11__Impl"
    // InternalGames.g:6846:1: rule__Action__Group__11__Impl : ( 'game' ) ;
    public final void rule__Action__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6850:1: ( ( 'game' ) )
            // InternalGames.g:6851:1: ( 'game' )
            {
            // InternalGames.g:6851:1: ( 'game' )
            // InternalGames.g:6852:2: 'game'
            {
             before(grammarAccess.getActionAccess().getGameKeyword_11()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getGameKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__11__Impl"


    // $ANTLR start "rule__Action__Group__12"
    // InternalGames.g:6861:1: rule__Action__Group__12 : rule__Action__Group__12__Impl rule__Action__Group__13 ;
    public final void rule__Action__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6865:1: ( rule__Action__Group__12__Impl rule__Action__Group__13 )
            // InternalGames.g:6866:2: rule__Action__Group__12__Impl rule__Action__Group__13
            {
            pushFollow(FOLLOW_53);
            rule__Action__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__12"


    // $ANTLR start "rule__Action__Group__12__Impl"
    // InternalGames.g:6873:1: rule__Action__Group__12__Impl : ( ( rule__Action__GameAssignment_12 ) ) ;
    public final void rule__Action__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6877:1: ( ( ( rule__Action__GameAssignment_12 ) ) )
            // InternalGames.g:6878:1: ( ( rule__Action__GameAssignment_12 ) )
            {
            // InternalGames.g:6878:1: ( ( rule__Action__GameAssignment_12 ) )
            // InternalGames.g:6879:2: ( rule__Action__GameAssignment_12 )
            {
             before(grammarAccess.getActionAccess().getGameAssignment_12()); 
            // InternalGames.g:6880:2: ( rule__Action__GameAssignment_12 )
            // InternalGames.g:6880:3: rule__Action__GameAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Action__GameAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGameAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__12__Impl"


    // $ANTLR start "rule__Action__Group__13"
    // InternalGames.g:6888:1: rule__Action__Group__13 : rule__Action__Group__13__Impl ;
    public final void rule__Action__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6892:1: ( rule__Action__Group__13__Impl )
            // InternalGames.g:6893:2: rule__Action__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__13"


    // $ANTLR start "rule__Action__Group__13__Impl"
    // InternalGames.g:6899:1: rule__Action__Group__13__Impl : ( '}' ) ;
    public final void rule__Action__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6903:1: ( ( '}' ) )
            // InternalGames.g:6904:1: ( '}' )
            {
            // InternalGames.g:6904:1: ( '}' )
            // InternalGames.g:6905:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_13()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__13__Impl"


    // $ANTLR start "rule__Action__Group_7__0"
    // InternalGames.g:6915:1: rule__Action__Group_7__0 : rule__Action__Group_7__0__Impl rule__Action__Group_7__1 ;
    public final void rule__Action__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6919:1: ( rule__Action__Group_7__0__Impl rule__Action__Group_7__1 )
            // InternalGames.g:6920:2: rule__Action__Group_7__0__Impl rule__Action__Group_7__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_7__0"


    // $ANTLR start "rule__Action__Group_7__0__Impl"
    // InternalGames.g:6927:1: rule__Action__Group_7__0__Impl : ( 'knowledgeGiven' ) ;
    public final void rule__Action__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6931:1: ( ( 'knowledgeGiven' ) )
            // InternalGames.g:6932:1: ( 'knowledgeGiven' )
            {
            // InternalGames.g:6932:1: ( 'knowledgeGiven' )
            // InternalGames.g:6933:2: 'knowledgeGiven'
            {
             before(grammarAccess.getActionAccess().getKnowledgeGivenKeyword_7_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getKnowledgeGivenKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_7__0__Impl"


    // $ANTLR start "rule__Action__Group_7__1"
    // InternalGames.g:6942:1: rule__Action__Group_7__1 : rule__Action__Group_7__1__Impl ;
    public final void rule__Action__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6946:1: ( rule__Action__Group_7__1__Impl )
            // InternalGames.g:6947:2: rule__Action__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_7__1"


    // $ANTLR start "rule__Action__Group_7__1__Impl"
    // InternalGames.g:6953:1: rule__Action__Group_7__1__Impl : ( ( rule__Action__KnowledgeGivenAssignment_7_1 )* ) ;
    public final void rule__Action__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6957:1: ( ( ( rule__Action__KnowledgeGivenAssignment_7_1 )* ) )
            // InternalGames.g:6958:1: ( ( rule__Action__KnowledgeGivenAssignment_7_1 )* )
            {
            // InternalGames.g:6958:1: ( ( rule__Action__KnowledgeGivenAssignment_7_1 )* )
            // InternalGames.g:6959:2: ( rule__Action__KnowledgeGivenAssignment_7_1 )*
            {
             before(grammarAccess.getActionAccess().getKnowledgeGivenAssignment_7_1()); 
            // InternalGames.g:6960:2: ( rule__Action__KnowledgeGivenAssignment_7_1 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalGames.g:6960:3: rule__Action__KnowledgeGivenAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Action__KnowledgeGivenAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getKnowledgeGivenAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_7__1__Impl"


    // $ANTLR start "rule__Action__Group_8__0"
    // InternalGames.g:6969:1: rule__Action__Group_8__0 : rule__Action__Group_8__0__Impl rule__Action__Group_8__1 ;
    public final void rule__Action__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6973:1: ( rule__Action__Group_8__0__Impl rule__Action__Group_8__1 )
            // InternalGames.g:6974:2: rule__Action__Group_8__0__Impl rule__Action__Group_8__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_8__0"


    // $ANTLR start "rule__Action__Group_8__0__Impl"
    // InternalGames.g:6981:1: rule__Action__Group_8__0__Impl : ( 'itemsGiven' ) ;
    public final void rule__Action__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:6985:1: ( ( 'itemsGiven' ) )
            // InternalGames.g:6986:1: ( 'itemsGiven' )
            {
            // InternalGames.g:6986:1: ( 'itemsGiven' )
            // InternalGames.g:6987:2: 'itemsGiven'
            {
             before(grammarAccess.getActionAccess().getItemsGivenKeyword_8_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getItemsGivenKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_8__0__Impl"


    // $ANTLR start "rule__Action__Group_8__1"
    // InternalGames.g:6996:1: rule__Action__Group_8__1 : rule__Action__Group_8__1__Impl ;
    public final void rule__Action__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7000:1: ( rule__Action__Group_8__1__Impl )
            // InternalGames.g:7001:2: rule__Action__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_8__1"


    // $ANTLR start "rule__Action__Group_8__1__Impl"
    // InternalGames.g:7007:1: rule__Action__Group_8__1__Impl : ( ( rule__Action__ItemsGivenAssignment_8_1 )* ) ;
    public final void rule__Action__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7011:1: ( ( ( rule__Action__ItemsGivenAssignment_8_1 )* ) )
            // InternalGames.g:7012:1: ( ( rule__Action__ItemsGivenAssignment_8_1 )* )
            {
            // InternalGames.g:7012:1: ( ( rule__Action__ItemsGivenAssignment_8_1 )* )
            // InternalGames.g:7013:2: ( rule__Action__ItemsGivenAssignment_8_1 )*
            {
             before(grammarAccess.getActionAccess().getItemsGivenAssignment_8_1()); 
            // InternalGames.g:7014:2: ( rule__Action__ItemsGivenAssignment_8_1 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_ID) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalGames.g:7014:3: rule__Action__ItemsGivenAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Action__ItemsGivenAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getItemsGivenAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_8__1__Impl"


    // $ANTLR start "rule__Action__Group_9__0"
    // InternalGames.g:7023:1: rule__Action__Group_9__0 : rule__Action__Group_9__0__Impl rule__Action__Group_9__1 ;
    public final void rule__Action__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7027:1: ( rule__Action__Group_9__0__Impl rule__Action__Group_9__1 )
            // InternalGames.g:7028:2: rule__Action__Group_9__0__Impl rule__Action__Group_9__1
            {
            pushFollow(FOLLOW_3);
            rule__Action__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_9__0"


    // $ANTLR start "rule__Action__Group_9__0__Impl"
    // InternalGames.g:7035:1: rule__Action__Group_9__0__Impl : ( 'itemsConsumed' ) ;
    public final void rule__Action__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7039:1: ( ( 'itemsConsumed' ) )
            // InternalGames.g:7040:1: ( 'itemsConsumed' )
            {
            // InternalGames.g:7040:1: ( 'itemsConsumed' )
            // InternalGames.g:7041:2: 'itemsConsumed'
            {
             before(grammarAccess.getActionAccess().getItemsConsumedKeyword_9_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getItemsConsumedKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_9__0__Impl"


    // $ANTLR start "rule__Action__Group_9__1"
    // InternalGames.g:7050:1: rule__Action__Group_9__1 : rule__Action__Group_9__1__Impl ;
    public final void rule__Action__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7054:1: ( rule__Action__Group_9__1__Impl )
            // InternalGames.g:7055:2: rule__Action__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_9__1"


    // $ANTLR start "rule__Action__Group_9__1__Impl"
    // InternalGames.g:7061:1: rule__Action__Group_9__1__Impl : ( ( rule__Action__ItemsConsumedAssignment_9_1 )* ) ;
    public final void rule__Action__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7065:1: ( ( ( rule__Action__ItemsConsumedAssignment_9_1 )* ) )
            // InternalGames.g:7066:1: ( ( rule__Action__ItemsConsumedAssignment_9_1 )* )
            {
            // InternalGames.g:7066:1: ( ( rule__Action__ItemsConsumedAssignment_9_1 )* )
            // InternalGames.g:7067:2: ( rule__Action__ItemsConsumedAssignment_9_1 )*
            {
             before(grammarAccess.getActionAccess().getItemsConsumedAssignment_9_1()); 
            // InternalGames.g:7068:2: ( rule__Action__ItemsConsumedAssignment_9_1 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalGames.g:7068:3: rule__Action__ItemsConsumedAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Action__ItemsConsumedAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getItemsConsumedAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_9__1__Impl"


    // $ANTLR start "rule__Action__Group_10__0"
    // InternalGames.g:7077:1: rule__Action__Group_10__0 : rule__Action__Group_10__0__Impl rule__Action__Group_10__1 ;
    public final void rule__Action__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7081:1: ( rule__Action__Group_10__0__Impl rule__Action__Group_10__1 )
            // InternalGames.g:7082:2: rule__Action__Group_10__0__Impl rule__Action__Group_10__1
            {
            pushFollow(FOLLOW_32);
            rule__Action__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Action__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_10__0"


    // $ANTLR start "rule__Action__Group_10__0__Impl"
    // InternalGames.g:7089:1: rule__Action__Group_10__0__Impl : ( 'conditionsActionsAvailable' ) ;
    public final void rule__Action__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7093:1: ( ( 'conditionsActionsAvailable' ) )
            // InternalGames.g:7094:1: ( 'conditionsActionsAvailable' )
            {
            // InternalGames.g:7094:1: ( 'conditionsActionsAvailable' )
            // InternalGames.g:7095:2: 'conditionsActionsAvailable'
            {
             before(grammarAccess.getActionAccess().getConditionsActionsAvailableKeyword_10_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getConditionsActionsAvailableKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_10__0__Impl"


    // $ANTLR start "rule__Action__Group_10__1"
    // InternalGames.g:7104:1: rule__Action__Group_10__1 : rule__Action__Group_10__1__Impl ;
    public final void rule__Action__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7108:1: ( rule__Action__Group_10__1__Impl )
            // InternalGames.g:7109:2: rule__Action__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Action__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_10__1"


    // $ANTLR start "rule__Action__Group_10__1__Impl"
    // InternalGames.g:7115:1: rule__Action__Group_10__1__Impl : ( ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )* ) ;
    public final void rule__Action__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7119:1: ( ( ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )* ) )
            // InternalGames.g:7120:1: ( ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )* )
            {
            // InternalGames.g:7120:1: ( ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )* )
            // InternalGames.g:7121:2: ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )*
            {
             before(grammarAccess.getActionAccess().getConditionsActionsAvailableAssignment_10_1()); 
            // InternalGames.g:7122:2: ( rule__Action__ConditionsActionsAvailableAssignment_10_1 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==59) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalGames.g:7122:3: rule__Action__ConditionsActionsAvailableAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Action__ConditionsActionsAvailableAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getActionAccess().getConditionsActionsAvailableAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_10__1__Impl"


    // $ANTLR start "rule__Interaction__Group__0"
    // InternalGames.g:7131:1: rule__Interaction__Group__0 : rule__Interaction__Group__0__Impl rule__Interaction__Group__1 ;
    public final void rule__Interaction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7135:1: ( rule__Interaction__Group__0__Impl rule__Interaction__Group__1 )
            // InternalGames.g:7136:2: rule__Interaction__Group__0__Impl rule__Interaction__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Interaction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__0"


    // $ANTLR start "rule__Interaction__Group__0__Impl"
    // InternalGames.g:7143:1: rule__Interaction__Group__0__Impl : ( 'interaction' ) ;
    public final void rule__Interaction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7147:1: ( ( 'interaction' ) )
            // InternalGames.g:7148:1: ( 'interaction' )
            {
            // InternalGames.g:7148:1: ( 'interaction' )
            // InternalGames.g:7149:2: 'interaction'
            {
             before(grammarAccess.getInteractionAccess().getInteractionKeyword_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getInteractionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__0__Impl"


    // $ANTLR start "rule__Interaction__Group__1"
    // InternalGames.g:7158:1: rule__Interaction__Group__1 : rule__Interaction__Group__1__Impl rule__Interaction__Group__2 ;
    public final void rule__Interaction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7162:1: ( rule__Interaction__Group__1__Impl rule__Interaction__Group__2 )
            // InternalGames.g:7163:2: rule__Interaction__Group__1__Impl rule__Interaction__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Interaction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__1"


    // $ANTLR start "rule__Interaction__Group__1__Impl"
    // InternalGames.g:7170:1: rule__Interaction__Group__1__Impl : ( ( rule__Interaction__NameAssignment_1 ) ) ;
    public final void rule__Interaction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7174:1: ( ( ( rule__Interaction__NameAssignment_1 ) ) )
            // InternalGames.g:7175:1: ( ( rule__Interaction__NameAssignment_1 ) )
            {
            // InternalGames.g:7175:1: ( ( rule__Interaction__NameAssignment_1 ) )
            // InternalGames.g:7176:2: ( rule__Interaction__NameAssignment_1 )
            {
             before(grammarAccess.getInteractionAccess().getNameAssignment_1()); 
            // InternalGames.g:7177:2: ( rule__Interaction__NameAssignment_1 )
            // InternalGames.g:7177:3: rule__Interaction__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInteractionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__1__Impl"


    // $ANTLR start "rule__Interaction__Group__2"
    // InternalGames.g:7185:1: rule__Interaction__Group__2 : rule__Interaction__Group__2__Impl rule__Interaction__Group__3 ;
    public final void rule__Interaction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7189:1: ( rule__Interaction__Group__2__Impl rule__Interaction__Group__3 )
            // InternalGames.g:7190:2: rule__Interaction__Group__2__Impl rule__Interaction__Group__3
            {
            pushFollow(FOLLOW_54);
            rule__Interaction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__2"


    // $ANTLR start "rule__Interaction__Group__2__Impl"
    // InternalGames.g:7197:1: rule__Interaction__Group__2__Impl : ( '{' ) ;
    public final void rule__Interaction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7201:1: ( ( '{' ) )
            // InternalGames.g:7202:1: ( '{' )
            {
            // InternalGames.g:7202:1: ( '{' )
            // InternalGames.g:7203:2: '{'
            {
             before(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__2__Impl"


    // $ANTLR start "rule__Interaction__Group__3"
    // InternalGames.g:7212:1: rule__Interaction__Group__3 : rule__Interaction__Group__3__Impl rule__Interaction__Group__4 ;
    public final void rule__Interaction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7216:1: ( rule__Interaction__Group__3__Impl rule__Interaction__Group__4 )
            // InternalGames.g:7217:2: rule__Interaction__Group__3__Impl rule__Interaction__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Interaction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__3"


    // $ANTLR start "rule__Interaction__Group__3__Impl"
    // InternalGames.g:7224:1: rule__Interaction__Group__3__Impl : ( 'propositions' ) ;
    public final void rule__Interaction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7228:1: ( ( 'propositions' ) )
            // InternalGames.g:7229:1: ( 'propositions' )
            {
            // InternalGames.g:7229:1: ( 'propositions' )
            // InternalGames.g:7230:2: 'propositions'
            {
             before(grammarAccess.getInteractionAccess().getPropositionsKeyword_3()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getPropositionsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__3__Impl"


    // $ANTLR start "rule__Interaction__Group__4"
    // InternalGames.g:7239:1: rule__Interaction__Group__4 : rule__Interaction__Group__4__Impl rule__Interaction__Group__5 ;
    public final void rule__Interaction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7243:1: ( rule__Interaction__Group__4__Impl rule__Interaction__Group__5 )
            // InternalGames.g:7244:2: rule__Interaction__Group__4__Impl rule__Interaction__Group__5
            {
            pushFollow(FOLLOW_55);
            rule__Interaction__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__4"


    // $ANTLR start "rule__Interaction__Group__4__Impl"
    // InternalGames.g:7251:1: rule__Interaction__Group__4__Impl : ( '{' ) ;
    public final void rule__Interaction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7255:1: ( ( '{' ) )
            // InternalGames.g:7256:1: ( '{' )
            {
            // InternalGames.g:7256:1: ( '{' )
            // InternalGames.g:7257:2: '{'
            {
             before(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__4__Impl"


    // $ANTLR start "rule__Interaction__Group__5"
    // InternalGames.g:7266:1: rule__Interaction__Group__5 : rule__Interaction__Group__5__Impl rule__Interaction__Group__6 ;
    public final void rule__Interaction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7270:1: ( rule__Interaction__Group__5__Impl rule__Interaction__Group__6 )
            // InternalGames.g:7271:2: rule__Interaction__Group__5__Impl rule__Interaction__Group__6
            {
            pushFollow(FOLLOW_55);
            rule__Interaction__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__5"


    // $ANTLR start "rule__Interaction__Group__5__Impl"
    // InternalGames.g:7278:1: rule__Interaction__Group__5__Impl : ( ( rule__Interaction__PropAssignment_5 )* ) ;
    public final void rule__Interaction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7282:1: ( ( ( rule__Interaction__PropAssignment_5 )* ) )
            // InternalGames.g:7283:1: ( ( rule__Interaction__PropAssignment_5 )* )
            {
            // InternalGames.g:7283:1: ( ( rule__Interaction__PropAssignment_5 )* )
            // InternalGames.g:7284:2: ( rule__Interaction__PropAssignment_5 )*
            {
             before(grammarAccess.getInteractionAccess().getPropAssignment_5()); 
            // InternalGames.g:7285:2: ( rule__Interaction__PropAssignment_5 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==69) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalGames.g:7285:3: rule__Interaction__PropAssignment_5
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__Interaction__PropAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

             after(grammarAccess.getInteractionAccess().getPropAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__5__Impl"


    // $ANTLR start "rule__Interaction__Group__6"
    // InternalGames.g:7293:1: rule__Interaction__Group__6 : rule__Interaction__Group__6__Impl rule__Interaction__Group__7 ;
    public final void rule__Interaction__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7297:1: ( rule__Interaction__Group__6__Impl rule__Interaction__Group__7 )
            // InternalGames.g:7298:2: rule__Interaction__Group__6__Impl rule__Interaction__Group__7
            {
            pushFollow(FOLLOW_57);
            rule__Interaction__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__6"


    // $ANTLR start "rule__Interaction__Group__6__Impl"
    // InternalGames.g:7305:1: rule__Interaction__Group__6__Impl : ( '}' ) ;
    public final void rule__Interaction__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7309:1: ( ( '}' ) )
            // InternalGames.g:7310:1: ( '}' )
            {
            // InternalGames.g:7310:1: ( '}' )
            // InternalGames.g:7311:2: '}'
            {
             before(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__6__Impl"


    // $ANTLR start "rule__Interaction__Group__7"
    // InternalGames.g:7320:1: rule__Interaction__Group__7 : rule__Interaction__Group__7__Impl rule__Interaction__Group__8 ;
    public final void rule__Interaction__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7324:1: ( rule__Interaction__Group__7__Impl rule__Interaction__Group__8 )
            // InternalGames.g:7325:2: rule__Interaction__Group__7__Impl rule__Interaction__Group__8
            {
            pushFollow(FOLLOW_57);
            rule__Interaction__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__7"


    // $ANTLR start "rule__Interaction__Group__7__Impl"
    // InternalGames.g:7332:1: rule__Interaction__Group__7__Impl : ( ( rule__Interaction__Group_7__0 )? ) ;
    public final void rule__Interaction__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7336:1: ( ( ( rule__Interaction__Group_7__0 )? ) )
            // InternalGames.g:7337:1: ( ( rule__Interaction__Group_7__0 )? )
            {
            // InternalGames.g:7337:1: ( ( rule__Interaction__Group_7__0 )? )
            // InternalGames.g:7338:2: ( rule__Interaction__Group_7__0 )?
            {
             before(grammarAccess.getInteractionAccess().getGroup_7()); 
            // InternalGames.g:7339:2: ( rule__Interaction__Group_7__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==67) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalGames.g:7339:3: rule__Interaction__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interaction__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInteractionAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__7__Impl"


    // $ANTLR start "rule__Interaction__Group__8"
    // InternalGames.g:7347:1: rule__Interaction__Group__8 : rule__Interaction__Group__8__Impl rule__Interaction__Group__9 ;
    public final void rule__Interaction__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7351:1: ( rule__Interaction__Group__8__Impl rule__Interaction__Group__9 )
            // InternalGames.g:7352:2: rule__Interaction__Group__8__Impl rule__Interaction__Group__9
            {
            pushFollow(FOLLOW_57);
            rule__Interaction__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__8"


    // $ANTLR start "rule__Interaction__Group__8__Impl"
    // InternalGames.g:7359:1: rule__Interaction__Group__8__Impl : ( ( rule__Interaction__Group_8__0 )? ) ;
    public final void rule__Interaction__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7363:1: ( ( ( rule__Interaction__Group_8__0 )? ) )
            // InternalGames.g:7364:1: ( ( rule__Interaction__Group_8__0 )? )
            {
            // InternalGames.g:7364:1: ( ( rule__Interaction__Group_8__0 )? )
            // InternalGames.g:7365:2: ( rule__Interaction__Group_8__0 )?
            {
             before(grammarAccess.getInteractionAccess().getGroup_8()); 
            // InternalGames.g:7366:2: ( rule__Interaction__Group_8__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==68) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalGames.g:7366:3: rule__Interaction__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interaction__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInteractionAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__8__Impl"


    // $ANTLR start "rule__Interaction__Group__9"
    // InternalGames.g:7374:1: rule__Interaction__Group__9 : rule__Interaction__Group__9__Impl ;
    public final void rule__Interaction__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7378:1: ( rule__Interaction__Group__9__Impl )
            // InternalGames.g:7379:2: rule__Interaction__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__9"


    // $ANTLR start "rule__Interaction__Group__9__Impl"
    // InternalGames.g:7385:1: rule__Interaction__Group__9__Impl : ( '}' ) ;
    public final void rule__Interaction__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7389:1: ( ( '}' ) )
            // InternalGames.g:7390:1: ( '}' )
            {
            // InternalGames.g:7390:1: ( '}' )
            // InternalGames.g:7391:2: '}'
            {
             before(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_9()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group__9__Impl"


    // $ANTLR start "rule__Interaction__Group_7__0"
    // InternalGames.g:7401:1: rule__Interaction__Group_7__0 : rule__Interaction__Group_7__0__Impl rule__Interaction__Group_7__1 ;
    public final void rule__Interaction__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7405:1: ( rule__Interaction__Group_7__0__Impl rule__Interaction__Group_7__1 )
            // InternalGames.g:7406:2: rule__Interaction__Group_7__0__Impl rule__Interaction__Group_7__1
            {
            pushFollow(FOLLOW_32);
            rule__Interaction__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_7__0"


    // $ANTLR start "rule__Interaction__Group_7__0__Impl"
    // InternalGames.g:7413:1: rule__Interaction__Group_7__0__Impl : ( 'conditionsBegin' ) ;
    public final void rule__Interaction__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7417:1: ( ( 'conditionsBegin' ) )
            // InternalGames.g:7418:1: ( 'conditionsBegin' )
            {
            // InternalGames.g:7418:1: ( 'conditionsBegin' )
            // InternalGames.g:7419:2: 'conditionsBegin'
            {
             before(grammarAccess.getInteractionAccess().getConditionsBeginKeyword_7_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getConditionsBeginKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_7__0__Impl"


    // $ANTLR start "rule__Interaction__Group_7__1"
    // InternalGames.g:7428:1: rule__Interaction__Group_7__1 : rule__Interaction__Group_7__1__Impl ;
    public final void rule__Interaction__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7432:1: ( rule__Interaction__Group_7__1__Impl )
            // InternalGames.g:7433:2: rule__Interaction__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_7__1"


    // $ANTLR start "rule__Interaction__Group_7__1__Impl"
    // InternalGames.g:7439:1: rule__Interaction__Group_7__1__Impl : ( ( rule__Interaction__ConditionsBeginAssignment_7_1 )* ) ;
    public final void rule__Interaction__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7443:1: ( ( ( rule__Interaction__ConditionsBeginAssignment_7_1 )* ) )
            // InternalGames.g:7444:1: ( ( rule__Interaction__ConditionsBeginAssignment_7_1 )* )
            {
            // InternalGames.g:7444:1: ( ( rule__Interaction__ConditionsBeginAssignment_7_1 )* )
            // InternalGames.g:7445:2: ( rule__Interaction__ConditionsBeginAssignment_7_1 )*
            {
             before(grammarAccess.getInteractionAccess().getConditionsBeginAssignment_7_1()); 
            // InternalGames.g:7446:2: ( rule__Interaction__ConditionsBeginAssignment_7_1 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==59) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalGames.g:7446:3: rule__Interaction__ConditionsBeginAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Interaction__ConditionsBeginAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

             after(grammarAccess.getInteractionAccess().getConditionsBeginAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_7__1__Impl"


    // $ANTLR start "rule__Interaction__Group_8__0"
    // InternalGames.g:7455:1: rule__Interaction__Group_8__0 : rule__Interaction__Group_8__0__Impl rule__Interaction__Group_8__1 ;
    public final void rule__Interaction__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7459:1: ( rule__Interaction__Group_8__0__Impl rule__Interaction__Group_8__1 )
            // InternalGames.g:7460:2: rule__Interaction__Group_8__0__Impl rule__Interaction__Group_8__1
            {
            pushFollow(FOLLOW_32);
            rule__Interaction__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interaction__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_8__0"


    // $ANTLR start "rule__Interaction__Group_8__0__Impl"
    // InternalGames.g:7467:1: rule__Interaction__Group_8__0__Impl : ( 'conditionsEnd' ) ;
    public final void rule__Interaction__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7471:1: ( ( 'conditionsEnd' ) )
            // InternalGames.g:7472:1: ( 'conditionsEnd' )
            {
            // InternalGames.g:7472:1: ( 'conditionsEnd' )
            // InternalGames.g:7473:2: 'conditionsEnd'
            {
             before(grammarAccess.getInteractionAccess().getConditionsEndKeyword_8_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getConditionsEndKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_8__0__Impl"


    // $ANTLR start "rule__Interaction__Group_8__1"
    // InternalGames.g:7482:1: rule__Interaction__Group_8__1 : rule__Interaction__Group_8__1__Impl ;
    public final void rule__Interaction__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7486:1: ( rule__Interaction__Group_8__1__Impl )
            // InternalGames.g:7487:2: rule__Interaction__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interaction__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_8__1"


    // $ANTLR start "rule__Interaction__Group_8__1__Impl"
    // InternalGames.g:7493:1: rule__Interaction__Group_8__1__Impl : ( ( rule__Interaction__ConditionsEndAssignment_8_1 )* ) ;
    public final void rule__Interaction__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7497:1: ( ( ( rule__Interaction__ConditionsEndAssignment_8_1 )* ) )
            // InternalGames.g:7498:1: ( ( rule__Interaction__ConditionsEndAssignment_8_1 )* )
            {
            // InternalGames.g:7498:1: ( ( rule__Interaction__ConditionsEndAssignment_8_1 )* )
            // InternalGames.g:7499:2: ( rule__Interaction__ConditionsEndAssignment_8_1 )*
            {
             before(grammarAccess.getInteractionAccess().getConditionsEndAssignment_8_1()); 
            // InternalGames.g:7500:2: ( rule__Interaction__ConditionsEndAssignment_8_1 )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==59) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalGames.g:7500:3: rule__Interaction__ConditionsEndAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__Interaction__ConditionsEndAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

             after(grammarAccess.getInteractionAccess().getConditionsEndAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__Group_8__1__Impl"


    // $ANTLR start "rule__Proposition__Group__0"
    // InternalGames.g:7509:1: rule__Proposition__Group__0 : rule__Proposition__Group__0__Impl rule__Proposition__Group__1 ;
    public final void rule__Proposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7513:1: ( rule__Proposition__Group__0__Impl rule__Proposition__Group__1 )
            // InternalGames.g:7514:2: rule__Proposition__Group__0__Impl rule__Proposition__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Proposition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0"


    // $ANTLR start "rule__Proposition__Group__0__Impl"
    // InternalGames.g:7521:1: rule__Proposition__Group__0__Impl : ( 'proposition' ) ;
    public final void rule__Proposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7525:1: ( ( 'proposition' ) )
            // InternalGames.g:7526:1: ( 'proposition' )
            {
            // InternalGames.g:7526:1: ( 'proposition' )
            // InternalGames.g:7527:2: 'proposition'
            {
             before(grammarAccess.getPropositionAccess().getPropositionKeyword_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getPropositionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0__Impl"


    // $ANTLR start "rule__Proposition__Group__1"
    // InternalGames.g:7536:1: rule__Proposition__Group__1 : rule__Proposition__Group__1__Impl rule__Proposition__Group__2 ;
    public final void rule__Proposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7540:1: ( rule__Proposition__Group__1__Impl rule__Proposition__Group__2 )
            // InternalGames.g:7541:2: rule__Proposition__Group__1__Impl rule__Proposition__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__Proposition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1"


    // $ANTLR start "rule__Proposition__Group__1__Impl"
    // InternalGames.g:7548:1: rule__Proposition__Group__1__Impl : ( '{' ) ;
    public final void rule__Proposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7552:1: ( ( '{' ) )
            // InternalGames.g:7553:1: ( '{' )
            {
            // InternalGames.g:7553:1: ( '{' )
            // InternalGames.g:7554:2: '{'
            {
             before(grammarAccess.getPropositionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1__Impl"


    // $ANTLR start "rule__Proposition__Group__2"
    // InternalGames.g:7563:1: rule__Proposition__Group__2 : rule__Proposition__Group__2__Impl rule__Proposition__Group__3 ;
    public final void rule__Proposition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7567:1: ( rule__Proposition__Group__2__Impl rule__Proposition__Group__3 )
            // InternalGames.g:7568:2: rule__Proposition__Group__2__Impl rule__Proposition__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Proposition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__2"


    // $ANTLR start "rule__Proposition__Group__2__Impl"
    // InternalGames.g:7575:1: rule__Proposition__Group__2__Impl : ( 'value' ) ;
    public final void rule__Proposition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7579:1: ( ( 'value' ) )
            // InternalGames.g:7580:1: ( 'value' )
            {
            // InternalGames.g:7580:1: ( 'value' )
            // InternalGames.g:7581:2: 'value'
            {
             before(grammarAccess.getPropositionAccess().getValueKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getValueKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__2__Impl"


    // $ANTLR start "rule__Proposition__Group__3"
    // InternalGames.g:7590:1: rule__Proposition__Group__3 : rule__Proposition__Group__3__Impl rule__Proposition__Group__4 ;
    public final void rule__Proposition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7594:1: ( rule__Proposition__Group__3__Impl rule__Proposition__Group__4 )
            // InternalGames.g:7595:2: rule__Proposition__Group__3__Impl rule__Proposition__Group__4
            {
            pushFollow(FOLLOW_58);
            rule__Proposition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__3"


    // $ANTLR start "rule__Proposition__Group__3__Impl"
    // InternalGames.g:7602:1: rule__Proposition__Group__3__Impl : ( ( rule__Proposition__ValueAssignment_3 ) ) ;
    public final void rule__Proposition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7606:1: ( ( ( rule__Proposition__ValueAssignment_3 ) ) )
            // InternalGames.g:7607:1: ( ( rule__Proposition__ValueAssignment_3 ) )
            {
            // InternalGames.g:7607:1: ( ( rule__Proposition__ValueAssignment_3 ) )
            // InternalGames.g:7608:2: ( rule__Proposition__ValueAssignment_3 )
            {
             before(grammarAccess.getPropositionAccess().getValueAssignment_3()); 
            // InternalGames.g:7609:2: ( rule__Proposition__ValueAssignment_3 )
            // InternalGames.g:7609:3: rule__Proposition__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__3__Impl"


    // $ANTLR start "rule__Proposition__Group__4"
    // InternalGames.g:7617:1: rule__Proposition__Group__4 : rule__Proposition__Group__4__Impl rule__Proposition__Group__5 ;
    public final void rule__Proposition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7621:1: ( rule__Proposition__Group__4__Impl rule__Proposition__Group__5 )
            // InternalGames.g:7622:2: rule__Proposition__Group__4__Impl rule__Proposition__Group__5
            {
            pushFollow(FOLLOW_53);
            rule__Proposition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__4"


    // $ANTLR start "rule__Proposition__Group__4__Impl"
    // InternalGames.g:7629:1: rule__Proposition__Group__4__Impl : ( ( rule__Proposition__ActAssignment_4 ) ) ;
    public final void rule__Proposition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7633:1: ( ( ( rule__Proposition__ActAssignment_4 ) ) )
            // InternalGames.g:7634:1: ( ( rule__Proposition__ActAssignment_4 ) )
            {
            // InternalGames.g:7634:1: ( ( rule__Proposition__ActAssignment_4 ) )
            // InternalGames.g:7635:2: ( rule__Proposition__ActAssignment_4 )
            {
             before(grammarAccess.getPropositionAccess().getActAssignment_4()); 
            // InternalGames.g:7636:2: ( rule__Proposition__ActAssignment_4 )
            // InternalGames.g:7636:3: rule__Proposition__ActAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__ActAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getActAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__4__Impl"


    // $ANTLR start "rule__Proposition__Group__5"
    // InternalGames.g:7644:1: rule__Proposition__Group__5 : rule__Proposition__Group__5__Impl ;
    public final void rule__Proposition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7648:1: ( rule__Proposition__Group__5__Impl )
            // InternalGames.g:7649:2: rule__Proposition__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__5"


    // $ANTLR start "rule__Proposition__Group__5__Impl"
    // InternalGames.g:7655:1: rule__Proposition__Group__5__Impl : ( '}' ) ;
    public final void rule__Proposition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7659:1: ( ( '}' ) )
            // InternalGames.g:7660:1: ( '}' )
            {
            // InternalGames.g:7660:1: ( '}' )
            // InternalGames.g:7661:2: '}'
            {
             before(grammarAccess.getPropositionAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__5__Impl"


    // $ANTLR start "rule__Game__NameAssignment_1"
    // InternalGames.g:7671:1: rule__Game__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Game__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7675:1: ( ( RULE_ID ) )
            // InternalGames.g:7676:2: ( RULE_ID )
            {
            // InternalGames.g:7676:2: ( RULE_ID )
            // InternalGames.g:7677:3: RULE_ID
            {
             before(grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__NameAssignment_1"


    // $ANTLR start "rule__Game__PlayerAssignment_3"
    // InternalGames.g:7686:1: rule__Game__PlayerAssignment_3 : ( rulePlayer ) ;
    public final void rule__Game__PlayerAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7690:1: ( ( rulePlayer ) )
            // InternalGames.g:7691:2: ( rulePlayer )
            {
            // InternalGames.g:7691:2: ( rulePlayer )
            // InternalGames.g:7692:3: rulePlayer
            {
             before(grammarAccess.getGameAccess().getPlayerPlayerParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePlayer();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPlayerPlayerParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PlayerAssignment_3"


    // $ANTLR start "rule__Game__PlacesAssignment_6"
    // InternalGames.g:7701:1: rule__Game__PlacesAssignment_6 : ( rulePlace ) ;
    public final void rule__Game__PlacesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7705:1: ( ( rulePlace ) )
            // InternalGames.g:7706:2: ( rulePlace )
            {
            // InternalGames.g:7706:2: ( rulePlace )
            // InternalGames.g:7707:3: rulePlace
            {
             before(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePlace();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PlacesAssignment_6"


    // $ANTLR start "rule__Game__PlacesAssignment_7_1"
    // InternalGames.g:7716:1: rule__Game__PlacesAssignment_7_1 : ( rulePlace ) ;
    public final void rule__Game__PlacesAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7720:1: ( ( rulePlace ) )
            // InternalGames.g:7721:2: ( rulePlace )
            {
            // InternalGames.g:7721:2: ( rulePlace )
            // InternalGames.g:7722:3: rulePlace
            {
             before(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            rulePlace();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPlacesPlaceParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PlacesAssignment_7_1"


    // $ANTLR start "rule__Game__KnowledgeAssignment_9_2"
    // InternalGames.g:7731:1: rule__Game__KnowledgeAssignment_9_2 : ( ruleKnowledge ) ;
    public final void rule__Game__KnowledgeAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7735:1: ( ( ruleKnowledge ) )
            // InternalGames.g:7736:2: ( ruleKnowledge )
            {
            // InternalGames.g:7736:2: ( ruleKnowledge )
            // InternalGames.g:7737:3: ruleKnowledge
            {
             before(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKnowledge();

            state._fsp--;

             after(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__KnowledgeAssignment_9_2"


    // $ANTLR start "rule__Game__KnowledgeAssignment_9_3_1"
    // InternalGames.g:7746:1: rule__Game__KnowledgeAssignment_9_3_1 : ( ruleKnowledge ) ;
    public final void rule__Game__KnowledgeAssignment_9_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7750:1: ( ( ruleKnowledge ) )
            // InternalGames.g:7751:2: ( ruleKnowledge )
            {
            // InternalGames.g:7751:2: ( ruleKnowledge )
            // InternalGames.g:7752:3: ruleKnowledge
            {
             before(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKnowledge();

            state._fsp--;

             after(grammarAccess.getGameAccess().getKnowledgeKnowledgeParserRuleCall_9_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__KnowledgeAssignment_9_3_1"


    // $ANTLR start "rule__Game__PeopleAssignment_12"
    // InternalGames.g:7761:1: rule__Game__PeopleAssignment_12 : ( rulePeople ) ;
    public final void rule__Game__PeopleAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7765:1: ( ( rulePeople ) )
            // InternalGames.g:7766:2: ( rulePeople )
            {
            // InternalGames.g:7766:2: ( rulePeople )
            // InternalGames.g:7767:3: rulePeople
            {
             before(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            rulePeople();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PeopleAssignment_12"


    // $ANTLR start "rule__Game__PeopleAssignment_13_1"
    // InternalGames.g:7776:1: rule__Game__PeopleAssignment_13_1 : ( rulePeople ) ;
    public final void rule__Game__PeopleAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7780:1: ( ( rulePeople ) )
            // InternalGames.g:7781:2: ( rulePeople )
            {
            // InternalGames.g:7781:2: ( rulePeople )
            // InternalGames.g:7782:3: rulePeople
            {
             before(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            rulePeople();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPeoplePeopleParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PeopleAssignment_13_1"


    // $ANTLR start "rule__Game__ItemsAssignment_15_2"
    // InternalGames.g:7791:1: rule__Game__ItemsAssignment_15_2 : ( ruleItem ) ;
    public final void rule__Game__ItemsAssignment_15_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7795:1: ( ( ruleItem ) )
            // InternalGames.g:7796:2: ( ruleItem )
            {
            // InternalGames.g:7796:2: ( ruleItem )
            // InternalGames.g:7797:3: ruleItem
            {
             before(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_2_0()); 
            pushFollow(FOLLOW_2);
            ruleItem();

            state._fsp--;

             after(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ItemsAssignment_15_2"


    // $ANTLR start "rule__Game__ItemsAssignment_15_3_1"
    // InternalGames.g:7806:1: rule__Game__ItemsAssignment_15_3_1 : ( ruleItem ) ;
    public final void rule__Game__ItemsAssignment_15_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7810:1: ( ( ruleItem ) )
            // InternalGames.g:7811:2: ( ruleItem )
            {
            // InternalGames.g:7811:2: ( ruleItem )
            // InternalGames.g:7812:3: ruleItem
            {
             before(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItem();

            state._fsp--;

             after(grammarAccess.getGameAccess().getItemsItemParserRuleCall_15_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__ItemsAssignment_15_3_1"


    // $ANTLR start "rule__Game__PathAssignment_18"
    // InternalGames.g:7821:1: rule__Game__PathAssignment_18 : ( rulePath ) ;
    public final void rule__Game__PathAssignment_18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7825:1: ( ( rulePath ) )
            // InternalGames.g:7826:2: ( rulePath )
            {
            // InternalGames.g:7826:2: ( rulePath )
            // InternalGames.g:7827:3: rulePath
            {
             before(grammarAccess.getGameAccess().getPathPathParserRuleCall_18_0()); 
            pushFollow(FOLLOW_2);
            rulePath();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPathPathParserRuleCall_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PathAssignment_18"


    // $ANTLR start "rule__Game__PathAssignment_19_1"
    // InternalGames.g:7836:1: rule__Game__PathAssignment_19_1 : ( rulePath ) ;
    public final void rule__Game__PathAssignment_19_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7840:1: ( ( rulePath ) )
            // InternalGames.g:7841:2: ( rulePath )
            {
            // InternalGames.g:7841:2: ( rulePath )
            // InternalGames.g:7842:3: rulePath
            {
             before(grammarAccess.getGameAccess().getPathPathParserRuleCall_19_1_0()); 
            pushFollow(FOLLOW_2);
            rulePath();

            state._fsp--;

             after(grammarAccess.getGameAccess().getPathPathParserRuleCall_19_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__PathAssignment_19_1"


    // $ANTLR start "rule__Game__RecipesAssignment_21_2"
    // InternalGames.g:7851:1: rule__Game__RecipesAssignment_21_2 : ( ruleRecipe ) ;
    public final void rule__Game__RecipesAssignment_21_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7855:1: ( ( ruleRecipe ) )
            // InternalGames.g:7856:2: ( ruleRecipe )
            {
            // InternalGames.g:7856:2: ( ruleRecipe )
            // InternalGames.g:7857:3: ruleRecipe
            {
             before(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRecipe();

            state._fsp--;

             after(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__RecipesAssignment_21_2"


    // $ANTLR start "rule__Game__RecipesAssignment_21_3_1"
    // InternalGames.g:7866:1: rule__Game__RecipesAssignment_21_3_1 : ( ruleRecipe ) ;
    public final void rule__Game__RecipesAssignment_21_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7870:1: ( ( ruleRecipe ) )
            // InternalGames.g:7871:2: ( ruleRecipe )
            {
            // InternalGames.g:7871:2: ( ruleRecipe )
            // InternalGames.g:7872:3: ruleRecipe
            {
             before(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRecipe();

            state._fsp--;

             after(grammarAccess.getGameAccess().getRecipesRecipeParserRuleCall_21_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__RecipesAssignment_21_3_1"


    // $ANTLR start "rule__Game__StartPlaceAssignment_23"
    // InternalGames.g:7881:1: rule__Game__StartPlaceAssignment_23 : ( ( RULE_ID ) ) ;
    public final void rule__Game__StartPlaceAssignment_23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7885:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:7886:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:7886:2: ( ( RULE_ID ) )
            // InternalGames.g:7887:3: ( RULE_ID )
            {
             before(grammarAccess.getGameAccess().getStartPlacePlaceCrossReference_23_0()); 
            // InternalGames.g:7888:3: ( RULE_ID )
            // InternalGames.g:7889:4: RULE_ID
            {
             before(grammarAccess.getGameAccess().getStartPlacePlaceIDTerminalRuleCall_23_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getStartPlacePlaceIDTerminalRuleCall_23_0_1()); 

            }

             after(grammarAccess.getGameAccess().getStartPlacePlaceCrossReference_23_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__StartPlaceAssignment_23"


    // $ANTLR start "rule__Game__EndPlaceAssignment_25"
    // InternalGames.g:7900:1: rule__Game__EndPlaceAssignment_25 : ( ( RULE_ID ) ) ;
    public final void rule__Game__EndPlaceAssignment_25() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7904:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:7905:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:7905:2: ( ( RULE_ID ) )
            // InternalGames.g:7906:3: ( RULE_ID )
            {
             before(grammarAccess.getGameAccess().getEndPlacePlaceCrossReference_25_0()); 
            // InternalGames.g:7907:3: ( RULE_ID )
            // InternalGames.g:7908:4: RULE_ID
            {
             before(grammarAccess.getGameAccess().getEndPlacePlaceIDTerminalRuleCall_25_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGameAccess().getEndPlacePlaceIDTerminalRuleCall_25_0_1()); 

            }

             after(grammarAccess.getGameAccess().getEndPlacePlaceCrossReference_25_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__EndPlaceAssignment_25"


    // $ANTLR start "rule__Game__DifficultyAssignment_26"
    // InternalGames.g:7919:1: rule__Game__DifficultyAssignment_26 : ( ruleDifficulty ) ;
    public final void rule__Game__DifficultyAssignment_26() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7923:1: ( ( ruleDifficulty ) )
            // InternalGames.g:7924:2: ( ruleDifficulty )
            {
            // InternalGames.g:7924:2: ( ruleDifficulty )
            // InternalGames.g:7925:3: ruleDifficulty
            {
             before(grammarAccess.getGameAccess().getDifficultyDifficultyParserRuleCall_26_0()); 
            pushFollow(FOLLOW_2);
            ruleDifficulty();

            state._fsp--;

             after(grammarAccess.getGameAccess().getDifficultyDifficultyParserRuleCall_26_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Game__DifficultyAssignment_26"


    // $ANTLR start "rule__Difficulty__LvlAssignment_1"
    // InternalGames.g:7934:1: rule__Difficulty__LvlAssignment_1 : ( RULE_INT ) ;
    public final void rule__Difficulty__LvlAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7938:1: ( ( RULE_INT ) )
            // InternalGames.g:7939:2: ( RULE_INT )
            {
            // InternalGames.g:7939:2: ( RULE_INT )
            // InternalGames.g:7940:3: RULE_INT
            {
             before(grammarAccess.getDifficultyAccess().getLvlINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getLvlINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__LvlAssignment_1"


    // $ANTLR start "rule__Difficulty__SizeMaxAssignment_4"
    // InternalGames.g:7949:1: rule__Difficulty__SizeMaxAssignment_4 : ( RULE_INT ) ;
    public final void rule__Difficulty__SizeMaxAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7953:1: ( ( RULE_INT ) )
            // InternalGames.g:7954:2: ( RULE_INT )
            {
            // InternalGames.g:7954:2: ( RULE_INT )
            // InternalGames.g:7955:3: RULE_INT
            {
             before(grammarAccess.getDifficultyAccess().getSizeMaxINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getSizeMaxINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__SizeMaxAssignment_4"


    // $ANTLR start "rule__Difficulty__ItemsAssignment_5_2"
    // InternalGames.g:7964:1: rule__Difficulty__ItemsAssignment_5_2 : ( ruleItemInSomething ) ;
    public final void rule__Difficulty__ItemsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7968:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:7969:2: ( ruleItemInSomething )
            {
            // InternalGames.g:7969:2: ( ruleItemInSomething )
            // InternalGames.g:7970:3: ruleItemInSomething
            {
             before(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__ItemsAssignment_5_2"


    // $ANTLR start "rule__Difficulty__ItemsAssignment_5_3_1"
    // InternalGames.g:7979:1: rule__Difficulty__ItemsAssignment_5_3_1 : ( ruleItemInSomething ) ;
    public final void rule__Difficulty__ItemsAssignment_5_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7983:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:7984:2: ( ruleItemInSomething )
            {
            // InternalGames.g:7984:2: ( ruleItemInSomething )
            // InternalGames.g:7985:3: ruleItemInSomething
            {
             before(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getDifficultyAccess().getItemsItemInSomethingParserRuleCall_5_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__ItemsAssignment_5_3_1"


    // $ANTLR start "rule__Difficulty__KnowledgesAssignment_6_1"
    // InternalGames.g:7994:1: rule__Difficulty__KnowledgesAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Difficulty__KnowledgesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:7998:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:7999:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:7999:2: ( ( RULE_ID ) )
            // InternalGames.g:8000:3: ( RULE_ID )
            {
             before(grammarAccess.getDifficultyAccess().getKnowledgesKnowledgeCrossReference_6_1_0()); 
            // InternalGames.g:8001:3: ( RULE_ID )
            // InternalGames.g:8002:4: RULE_ID
            {
             before(grammarAccess.getDifficultyAccess().getKnowledgesKnowledgeIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDifficultyAccess().getKnowledgesKnowledgeIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getDifficultyAccess().getKnowledgesKnowledgeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Difficulty__KnowledgesAssignment_6_1"


    // $ANTLR start "rule__Player__NameAssignment_1"
    // InternalGames.g:8013:1: rule__Player__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Player__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8017:1: ( ( RULE_STRING ) )
            // InternalGames.g:8018:2: ( RULE_STRING )
            {
            // InternalGames.g:8018:2: ( RULE_STRING )
            // InternalGames.g:8019:3: RULE_STRING
            {
             before(grammarAccess.getPlayerAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__NameAssignment_1"


    // $ANTLR start "rule__Player__ItemsAssignment_3_1"
    // InternalGames.g:8028:1: rule__Player__ItemsAssignment_3_1 : ( ruleItemInSomething ) ;
    public final void rule__Player__ItemsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8032:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8033:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8033:2: ( ruleItemInSomething )
            // InternalGames.g:8034:3: ruleItemInSomething
            {
             before(grammarAccess.getPlayerAccess().getItemsItemInSomethingParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getPlayerAccess().getItemsItemInSomethingParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__ItemsAssignment_3_1"


    // $ANTLR start "rule__Player__KnowledgeAssignment_4_1"
    // InternalGames.g:8043:1: rule__Player__KnowledgeAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Player__KnowledgeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8047:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8048:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8048:2: ( ( RULE_ID ) )
            // InternalGames.g:8049:3: ( RULE_ID )
            {
             before(grammarAccess.getPlayerAccess().getKnowledgeKnowledgeCrossReference_4_1_0()); 
            // InternalGames.g:8050:3: ( RULE_ID )
            // InternalGames.g:8051:4: RULE_ID
            {
             before(grammarAccess.getPlayerAccess().getKnowledgeKnowledgeIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPlayerAccess().getKnowledgeKnowledgeIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getPlayerAccess().getKnowledgeKnowledgeCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Player__KnowledgeAssignment_4_1"


    // $ANTLR start "rule__People__NameAssignment_1"
    // InternalGames.g:8062:1: rule__People__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__People__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8066:1: ( ( RULE_ID ) )
            // InternalGames.g:8067:2: ( RULE_ID )
            {
            // InternalGames.g:8067:2: ( RULE_ID )
            // InternalGames.g:8068:3: RULE_ID
            {
             before(grammarAccess.getPeopleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__NameAssignment_1"


    // $ANTLR start "rule__People__DescriptionAssignment_4"
    // InternalGames.g:8077:1: rule__People__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__People__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8081:1: ( ( RULE_STRING ) )
            // InternalGames.g:8082:2: ( RULE_STRING )
            {
            // InternalGames.g:8082:2: ( RULE_STRING )
            // InternalGames.g:8083:3: RULE_STRING
            {
             before(grammarAccess.getPeopleAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__DescriptionAssignment_4"


    // $ANTLR start "rule__People__VisibleAssignment_6"
    // InternalGames.g:8092:1: rule__People__VisibleAssignment_6 : ( RULE_INT ) ;
    public final void rule__People__VisibleAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8096:1: ( ( RULE_INT ) )
            // InternalGames.g:8097:2: ( RULE_INT )
            {
            // InternalGames.g:8097:2: ( RULE_INT )
            // InternalGames.g:8098:3: RULE_INT
            {
             before(grammarAccess.getPeopleAccess().getVisibleINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getVisibleINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__VisibleAssignment_6"


    // $ANTLR start "rule__People__ConditionsVisibleAssignment_7_1"
    // InternalGames.g:8107:1: rule__People__ConditionsVisibleAssignment_7_1 : ( ruleCondition ) ;
    public final void rule__People__ConditionsVisibleAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8111:1: ( ( ruleCondition ) )
            // InternalGames.g:8112:2: ( ruleCondition )
            {
            // InternalGames.g:8112:2: ( ruleCondition )
            // InternalGames.g:8113:3: ruleCondition
            {
             before(grammarAccess.getPeopleAccess().getConditionsVisibleConditionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPeopleAccess().getConditionsVisibleConditionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__ConditionsVisibleAssignment_7_1"


    // $ANTLR start "rule__People__ActiveAssignment_9"
    // InternalGames.g:8122:1: rule__People__ActiveAssignment_9 : ( RULE_INT ) ;
    public final void rule__People__ActiveAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8126:1: ( ( RULE_INT ) )
            // InternalGames.g:8127:2: ( RULE_INT )
            {
            // InternalGames.g:8127:2: ( RULE_INT )
            // InternalGames.g:8128:3: RULE_INT
            {
             before(grammarAccess.getPeopleAccess().getActiveINTTerminalRuleCall_9_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getActiveINTTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__ActiveAssignment_9"


    // $ANTLR start "rule__People__ConditionsActiveAssignment_10_1"
    // InternalGames.g:8137:1: rule__People__ConditionsActiveAssignment_10_1 : ( ruleCondition ) ;
    public final void rule__People__ConditionsActiveAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8141:1: ( ( ruleCondition ) )
            // InternalGames.g:8142:2: ( ruleCondition )
            {
            // InternalGames.g:8142:2: ( ruleCondition )
            // InternalGames.g:8143:3: ruleCondition
            {
             before(grammarAccess.getPeopleAccess().getConditionsActiveConditionParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPeopleAccess().getConditionsActiveConditionParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__ConditionsActiveAssignment_10_1"


    // $ANTLR start "rule__People__IsMandatoryAssignment_12"
    // InternalGames.g:8152:1: rule__People__IsMandatoryAssignment_12 : ( RULE_INT ) ;
    public final void rule__People__IsMandatoryAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8156:1: ( ( RULE_INT ) )
            // InternalGames.g:8157:2: ( RULE_INT )
            {
            // InternalGames.g:8157:2: ( RULE_INT )
            // InternalGames.g:8158:3: RULE_INT
            {
             before(grammarAccess.getPeopleAccess().getIsMandatoryINTTerminalRuleCall_12_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPeopleAccess().getIsMandatoryINTTerminalRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__IsMandatoryAssignment_12"


    // $ANTLR start "rule__People__InteractionAssignment_13"
    // InternalGames.g:8167:1: rule__People__InteractionAssignment_13 : ( ruleInteraction ) ;
    public final void rule__People__InteractionAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8171:1: ( ( ruleInteraction ) )
            // InternalGames.g:8172:2: ( ruleInteraction )
            {
            // InternalGames.g:8172:2: ( ruleInteraction )
            // InternalGames.g:8173:3: ruleInteraction
            {
             before(grammarAccess.getPeopleAccess().getInteractionInteractionParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleInteraction();

            state._fsp--;

             after(grammarAccess.getPeopleAccess().getInteractionInteractionParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__People__InteractionAssignment_13"


    // $ANTLR start "rule__Path__NameAssignment_1"
    // InternalGames.g:8182:1: rule__Path__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Path__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8186:1: ( ( RULE_ID ) )
            // InternalGames.g:8187:2: ( RULE_ID )
            {
            // InternalGames.g:8187:2: ( RULE_ID )
            // InternalGames.g:8188:3: RULE_ID
            {
             before(grammarAccess.getPathAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__NameAssignment_1"


    // $ANTLR start "rule__Path__DescriptionAssignment_4"
    // InternalGames.g:8197:1: rule__Path__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Path__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8201:1: ( ( RULE_STRING ) )
            // InternalGames.g:8202:2: ( RULE_STRING )
            {
            // InternalGames.g:8202:2: ( RULE_STRING )
            // InternalGames.g:8203:3: RULE_STRING
            {
             before(grammarAccess.getPathAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__DescriptionAssignment_4"


    // $ANTLR start "rule__Path__VisibleAssignment_6"
    // InternalGames.g:8212:1: rule__Path__VisibleAssignment_6 : ( RULE_INT ) ;
    public final void rule__Path__VisibleAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8216:1: ( ( RULE_INT ) )
            // InternalGames.g:8217:2: ( RULE_INT )
            {
            // InternalGames.g:8217:2: ( RULE_INT )
            // InternalGames.g:8218:3: RULE_INT
            {
             before(grammarAccess.getPathAccess().getVisibleINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getVisibleINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__VisibleAssignment_6"


    // $ANTLR start "rule__Path__ConditionVisibleAssignment_7_1"
    // InternalGames.g:8227:1: rule__Path__ConditionVisibleAssignment_7_1 : ( ruleCondition ) ;
    public final void rule__Path__ConditionVisibleAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8231:1: ( ( ruleCondition ) )
            // InternalGames.g:8232:2: ( ruleCondition )
            {
            // InternalGames.g:8232:2: ( ruleCondition )
            // InternalGames.g:8233:3: ruleCondition
            {
             before(grammarAccess.getPathAccess().getConditionVisibleConditionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPathAccess().getConditionVisibleConditionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__ConditionVisibleAssignment_7_1"


    // $ANTLR start "rule__Path__EndPlaceAssignment_9"
    // InternalGames.g:8242:1: rule__Path__EndPlaceAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__Path__EndPlaceAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8246:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8247:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8247:2: ( ( RULE_ID ) )
            // InternalGames.g:8248:3: ( RULE_ID )
            {
             before(grammarAccess.getPathAccess().getEndPlacePlaceCrossReference_9_0()); 
            // InternalGames.g:8249:3: ( RULE_ID )
            // InternalGames.g:8250:4: RULE_ID
            {
             before(grammarAccess.getPathAccess().getEndPlacePlaceIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getEndPlacePlaceIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getPathAccess().getEndPlacePlaceCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__EndPlaceAssignment_9"


    // $ANTLR start "rule__Path__IsOpenAssignment_11"
    // InternalGames.g:8261:1: rule__Path__IsOpenAssignment_11 : ( RULE_INT ) ;
    public final void rule__Path__IsOpenAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8265:1: ( ( RULE_INT ) )
            // InternalGames.g:8266:2: ( RULE_INT )
            {
            // InternalGames.g:8266:2: ( RULE_INT )
            // InternalGames.g:8267:3: RULE_INT
            {
             before(grammarAccess.getPathAccess().getIsOpenINTTerminalRuleCall_11_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getIsOpenINTTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__IsOpenAssignment_11"


    // $ANTLR start "rule__Path__ConditionsOpeningAssignment_12_1"
    // InternalGames.g:8276:1: rule__Path__ConditionsOpeningAssignment_12_1 : ( ruleCondition ) ;
    public final void rule__Path__ConditionsOpeningAssignment_12_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8280:1: ( ( ruleCondition ) )
            // InternalGames.g:8281:2: ( ruleCondition )
            {
            // InternalGames.g:8281:2: ( ruleCondition )
            // InternalGames.g:8282:3: ruleCondition
            {
             before(grammarAccess.getPathAccess().getConditionsOpeningConditionParserRuleCall_12_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPathAccess().getConditionsOpeningConditionParserRuleCall_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__ConditionsOpeningAssignment_12_1"


    // $ANTLR start "rule__Path__IsMandatoryAssignment_14"
    // InternalGames.g:8291:1: rule__Path__IsMandatoryAssignment_14 : ( RULE_INT ) ;
    public final void rule__Path__IsMandatoryAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8295:1: ( ( RULE_INT ) )
            // InternalGames.g:8296:2: ( RULE_INT )
            {
            // InternalGames.g:8296:2: ( RULE_INT )
            // InternalGames.g:8297:3: RULE_INT
            {
             before(grammarAccess.getPathAccess().getIsMandatoryINTTerminalRuleCall_14_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getIsMandatoryINTTerminalRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__IsMandatoryAssignment_14"


    // $ANTLR start "rule__Path__KnowledgeGivenAssignment_15_1"
    // InternalGames.g:8306:1: rule__Path__KnowledgeGivenAssignment_15_1 : ( ( RULE_ID ) ) ;
    public final void rule__Path__KnowledgeGivenAssignment_15_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8310:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8311:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8311:2: ( ( RULE_ID ) )
            // InternalGames.g:8312:3: ( RULE_ID )
            {
             before(grammarAccess.getPathAccess().getKnowledgeGivenKnowledgeCrossReference_15_1_0()); 
            // InternalGames.g:8313:3: ( RULE_ID )
            // InternalGames.g:8314:4: RULE_ID
            {
             before(grammarAccess.getPathAccess().getKnowledgeGivenKnowledgeIDTerminalRuleCall_15_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getKnowledgeGivenKnowledgeIDTerminalRuleCall_15_1_0_1()); 

            }

             after(grammarAccess.getPathAccess().getKnowledgeGivenKnowledgeCrossReference_15_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__KnowledgeGivenAssignment_15_1"


    // $ANTLR start "rule__Path__ItemsGivenAssignment_16_1"
    // InternalGames.g:8325:1: rule__Path__ItemsGivenAssignment_16_1 : ( ruleItemInSomething ) ;
    public final void rule__Path__ItemsGivenAssignment_16_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8329:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8330:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8330:2: ( ruleItemInSomething )
            // InternalGames.g:8331:3: ruleItemInSomething
            {
             before(grammarAccess.getPathAccess().getItemsGivenItemInSomethingParserRuleCall_16_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getPathAccess().getItemsGivenItemInSomethingParserRuleCall_16_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__ItemsGivenAssignment_16_1"


    // $ANTLR start "rule__Path__ItemsConsumedAssignment_17_1"
    // InternalGames.g:8340:1: rule__Path__ItemsConsumedAssignment_17_1 : ( ruleItemInSomething ) ;
    public final void rule__Path__ItemsConsumedAssignment_17_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8344:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8345:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8345:2: ( ruleItemInSomething )
            // InternalGames.g:8346:3: ruleItemInSomething
            {
             before(grammarAccess.getPathAccess().getItemsConsumedItemInSomethingParserRuleCall_17_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getPathAccess().getItemsConsumedItemInSomethingParserRuleCall_17_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__ItemsConsumedAssignment_17_1"


    // $ANTLR start "rule__Item__NameAssignment_1"
    // InternalGames.g:8355:1: rule__Item__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Item__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8359:1: ( ( RULE_ID ) )
            // InternalGames.g:8360:2: ( RULE_ID )
            {
            // InternalGames.g:8360:2: ( RULE_ID )
            // InternalGames.g:8361:3: RULE_ID
            {
             before(grammarAccess.getItemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__NameAssignment_1"


    // $ANTLR start "rule__Item__SizeAssignment_4"
    // InternalGames.g:8370:1: rule__Item__SizeAssignment_4 : ( RULE_INT ) ;
    public final void rule__Item__SizeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8374:1: ( ( RULE_INT ) )
            // InternalGames.g:8375:2: ( RULE_INT )
            {
            // InternalGames.g:8375:2: ( RULE_INT )
            // InternalGames.g:8376:3: RULE_INT
            {
             before(grammarAccess.getItemAccess().getSizeINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getSizeINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__SizeAssignment_4"


    // $ANTLR start "rule__Item__DescriptionAssignment_6"
    // InternalGames.g:8385:1: rule__Item__DescriptionAssignment_6 : ( RULE_STRING ) ;
    public final void rule__Item__DescriptionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8389:1: ( ( RULE_STRING ) )
            // InternalGames.g:8390:2: ( RULE_STRING )
            {
            // InternalGames.g:8390:2: ( RULE_STRING )
            // InternalGames.g:8391:3: RULE_STRING
            {
             before(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getDescriptionSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__DescriptionAssignment_6"


    // $ANTLR start "rule__Item__VisibleAssignment_8"
    // InternalGames.g:8400:1: rule__Item__VisibleAssignment_8 : ( RULE_INT ) ;
    public final void rule__Item__VisibleAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8404:1: ( ( RULE_INT ) )
            // InternalGames.g:8405:2: ( RULE_INT )
            {
            // InternalGames.g:8405:2: ( RULE_INT )
            // InternalGames.g:8406:3: RULE_INT
            {
             before(grammarAccess.getItemAccess().getVisibleINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getVisibleINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__VisibleAssignment_8"


    // $ANTLR start "rule__Item__ConditionsVisibleAssignment_9_1"
    // InternalGames.g:8415:1: rule__Item__ConditionsVisibleAssignment_9_1 : ( ruleCondition ) ;
    public final void rule__Item__ConditionsVisibleAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8419:1: ( ( ruleCondition ) )
            // InternalGames.g:8420:2: ( ruleCondition )
            {
            // InternalGames.g:8420:2: ( ruleCondition )
            // InternalGames.g:8421:3: ruleCondition
            {
             before(grammarAccess.getItemAccess().getConditionsVisibleConditionParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getItemAccess().getConditionsVisibleConditionParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ConditionsVisibleAssignment_9_1"


    // $ANTLR start "rule__Item__ActiveAssignment_11"
    // InternalGames.g:8430:1: rule__Item__ActiveAssignment_11 : ( RULE_INT ) ;
    public final void rule__Item__ActiveAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8434:1: ( ( RULE_INT ) )
            // InternalGames.g:8435:2: ( RULE_INT )
            {
            // InternalGames.g:8435:2: ( RULE_INT )
            // InternalGames.g:8436:3: RULE_INT
            {
             before(grammarAccess.getItemAccess().getActiveINTTerminalRuleCall_11_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getActiveINTTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ActiveAssignment_11"


    // $ANTLR start "rule__Item__ConditionsActiveAssignment_13"
    // InternalGames.g:8445:1: rule__Item__ConditionsActiveAssignment_13 : ( ruleCondition ) ;
    public final void rule__Item__ConditionsActiveAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8449:1: ( ( ruleCondition ) )
            // InternalGames.g:8450:2: ( ruleCondition )
            {
            // InternalGames.g:8450:2: ( ruleCondition )
            // InternalGames.g:8451:3: ruleCondition
            {
             before(grammarAccess.getItemAccess().getConditionsActiveConditionParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getItemAccess().getConditionsActiveConditionParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ConditionsActiveAssignment_13"


    // $ANTLR start "rule__Item__CanPutDownAssignment_15"
    // InternalGames.g:8460:1: rule__Item__CanPutDownAssignment_15 : ( RULE_INT ) ;
    public final void rule__Item__CanPutDownAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8464:1: ( ( RULE_INT ) )
            // InternalGames.g:8465:2: ( RULE_INT )
            {
            // InternalGames.g:8465:2: ( RULE_INT )
            // InternalGames.g:8466:3: RULE_INT
            {
             before(grammarAccess.getItemAccess().getCanPutDownINTTerminalRuleCall_15_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemAccess().getCanPutDownINTTerminalRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__CanPutDownAssignment_15"


    // $ANTLR start "rule__Item__ConditionsPutDownAssignment_16_1"
    // InternalGames.g:8475:1: rule__Item__ConditionsPutDownAssignment_16_1 : ( ruleCondition ) ;
    public final void rule__Item__ConditionsPutDownAssignment_16_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8479:1: ( ( ruleCondition ) )
            // InternalGames.g:8480:2: ( ruleCondition )
            {
            // InternalGames.g:8480:2: ( ruleCondition )
            // InternalGames.g:8481:3: ruleCondition
            {
             before(grammarAccess.getItemAccess().getConditionsPutDownConditionParserRuleCall_16_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getItemAccess().getConditionsPutDownConditionParserRuleCall_16_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ConditionsPutDownAssignment_16_1"


    // $ANTLR start "rule__Item__ConditionsGiveAssignment_17_1"
    // InternalGames.g:8490:1: rule__Item__ConditionsGiveAssignment_17_1 : ( ruleCondition ) ;
    public final void rule__Item__ConditionsGiveAssignment_17_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8494:1: ( ( ruleCondition ) )
            // InternalGames.g:8495:2: ( ruleCondition )
            {
            // InternalGames.g:8495:2: ( ruleCondition )
            // InternalGames.g:8496:3: ruleCondition
            {
             before(grammarAccess.getItemAccess().getConditionsGiveConditionParserRuleCall_17_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getItemAccess().getConditionsGiveConditionParserRuleCall_17_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ConditionsGiveAssignment_17_1"


    // $ANTLR start "rule__Item__ConditionsConsumedAssignment_18_1"
    // InternalGames.g:8505:1: rule__Item__ConditionsConsumedAssignment_18_1 : ( ruleCondition ) ;
    public final void rule__Item__ConditionsConsumedAssignment_18_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8509:1: ( ( ruleCondition ) )
            // InternalGames.g:8510:2: ( ruleCondition )
            {
            // InternalGames.g:8510:2: ( ruleCondition )
            // InternalGames.g:8511:3: ruleCondition
            {
             before(grammarAccess.getItemAccess().getConditionsConsumedConditionParserRuleCall_18_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getItemAccess().getConditionsConsumedConditionParserRuleCall_18_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Item__ConditionsConsumedAssignment_18_1"


    // $ANTLR start "rule__ItemInSomething__ItemAssignment_0"
    // InternalGames.g:8520:1: rule__ItemInSomething__ItemAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ItemInSomething__ItemAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8524:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8525:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8525:2: ( ( RULE_ID ) )
            // InternalGames.g:8526:3: ( RULE_ID )
            {
             before(grammarAccess.getItemInSomethingAccess().getItemItemCrossReference_0_0()); 
            // InternalGames.g:8527:3: ( RULE_ID )
            // InternalGames.g:8528:4: RULE_ID
            {
             before(grammarAccess.getItemInSomethingAccess().getItemItemIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getItemInSomethingAccess().getItemItemIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getItemInSomethingAccess().getItemItemCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__ItemAssignment_0"


    // $ANTLR start "rule__ItemInSomething__QuantiteAssignment_2"
    // InternalGames.g:8539:1: rule__ItemInSomething__QuantiteAssignment_2 : ( RULE_INT ) ;
    public final void rule__ItemInSomething__QuantiteAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8543:1: ( ( RULE_INT ) )
            // InternalGames.g:8544:2: ( RULE_INT )
            {
            // InternalGames.g:8544:2: ( RULE_INT )
            // InternalGames.g:8545:3: RULE_INT
            {
             before(grammarAccess.getItemInSomethingAccess().getQuantiteINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemInSomethingAccess().getQuantiteINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInSomething__QuantiteAssignment_2"


    // $ANTLR start "rule__Recipe__NameAssignment_1"
    // InternalGames.g:8554:1: rule__Recipe__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Recipe__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8558:1: ( ( RULE_ID ) )
            // InternalGames.g:8559:2: ( RULE_ID )
            {
            // InternalGames.g:8559:2: ( RULE_ID )
            // InternalGames.g:8560:3: RULE_ID
            {
             before(grammarAccess.getRecipeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRecipeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__NameAssignment_1"


    // $ANTLR start "rule__Recipe__ObjectsUsedAssignment_4"
    // InternalGames.g:8569:1: rule__Recipe__ObjectsUsedAssignment_4 : ( ruleItemInSomething ) ;
    public final void rule__Recipe__ObjectsUsedAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8573:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8574:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8574:2: ( ruleItemInSomething )
            // InternalGames.g:8575:3: ruleItemInSomething
            {
             before(grammarAccess.getRecipeAccess().getObjectsUsedItemInSomethingParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getRecipeAccess().getObjectsUsedItemInSomethingParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__ObjectsUsedAssignment_4"


    // $ANTLR start "rule__Recipe__ConditionsAssignment_5_1"
    // InternalGames.g:8584:1: rule__Recipe__ConditionsAssignment_5_1 : ( ruleCondition ) ;
    public final void rule__Recipe__ConditionsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8588:1: ( ( ruleCondition ) )
            // InternalGames.g:8589:2: ( ruleCondition )
            {
            // InternalGames.g:8589:2: ( ruleCondition )
            // InternalGames.g:8590:3: ruleCondition
            {
             before(grammarAccess.getRecipeAccess().getConditionsConditionParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getRecipeAccess().getConditionsConditionParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__ConditionsAssignment_5_1"


    // $ANTLR start "rule__Recipe__ItemsMadeAssignment_7"
    // InternalGames.g:8599:1: rule__Recipe__ItemsMadeAssignment_7 : ( ruleItemInSomething ) ;
    public final void rule__Recipe__ItemsMadeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8603:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8604:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8604:2: ( ruleItemInSomething )
            // InternalGames.g:8605:3: ruleItemInSomething
            {
             before(grammarAccess.getRecipeAccess().getItemsMadeItemInSomethingParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getRecipeAccess().getItemsMadeItemInSomethingParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recipe__ItemsMadeAssignment_7"


    // $ANTLR start "rule__Knowledge__NameAssignment_1"
    // InternalGames.g:8614:1: rule__Knowledge__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Knowledge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8618:1: ( ( RULE_ID ) )
            // InternalGames.g:8619:2: ( RULE_ID )
            {
            // InternalGames.g:8619:2: ( RULE_ID )
            // InternalGames.g:8620:3: RULE_ID
            {
             before(grammarAccess.getKnowledgeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__NameAssignment_1"


    // $ANTLR start "rule__Knowledge__DescriptionAssignment_4"
    // InternalGames.g:8629:1: rule__Knowledge__DescriptionAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Knowledge__DescriptionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8633:1: ( ( RULE_STRING ) )
            // InternalGames.g:8634:2: ( RULE_STRING )
            {
            // InternalGames.g:8634:2: ( RULE_STRING )
            // InternalGames.g:8635:3: RULE_STRING
            {
             before(grammarAccess.getKnowledgeAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__DescriptionAssignment_4"


    // $ANTLR start "rule__Knowledge__VisibleAssignment_6"
    // InternalGames.g:8644:1: rule__Knowledge__VisibleAssignment_6 : ( RULE_INT ) ;
    public final void rule__Knowledge__VisibleAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8648:1: ( ( RULE_INT ) )
            // InternalGames.g:8649:2: ( RULE_INT )
            {
            // InternalGames.g:8649:2: ( RULE_INT )
            // InternalGames.g:8650:3: RULE_INT
            {
             before(grammarAccess.getKnowledgeAccess().getVisibleINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getVisibleINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__VisibleAssignment_6"


    // $ANTLR start "rule__Knowledge__ConditionsVisibleAssignment_7_1"
    // InternalGames.g:8659:1: rule__Knowledge__ConditionsVisibleAssignment_7_1 : ( ruleCondition ) ;
    public final void rule__Knowledge__ConditionsVisibleAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8663:1: ( ( ruleCondition ) )
            // InternalGames.g:8664:2: ( ruleCondition )
            {
            // InternalGames.g:8664:2: ( ruleCondition )
            // InternalGames.g:8665:3: ruleCondition
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsVisibleConditionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getKnowledgeAccess().getConditionsVisibleConditionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__ConditionsVisibleAssignment_7_1"


    // $ANTLR start "rule__Knowledge__ActiveAssignment_9"
    // InternalGames.g:8674:1: rule__Knowledge__ActiveAssignment_9 : ( RULE_INT ) ;
    public final void rule__Knowledge__ActiveAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8678:1: ( ( RULE_INT ) )
            // InternalGames.g:8679:2: ( RULE_INT )
            {
            // InternalGames.g:8679:2: ( RULE_INT )
            // InternalGames.g:8680:3: RULE_INT
            {
             before(grammarAccess.getKnowledgeAccess().getActiveINTTerminalRuleCall_9_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getKnowledgeAccess().getActiveINTTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__ActiveAssignment_9"


    // $ANTLR start "rule__Knowledge__ConditionsActiveAssignment_10_1"
    // InternalGames.g:8689:1: rule__Knowledge__ConditionsActiveAssignment_10_1 : ( ruleCondition ) ;
    public final void rule__Knowledge__ConditionsActiveAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8693:1: ( ( ruleCondition ) )
            // InternalGames.g:8694:2: ( ruleCondition )
            {
            // InternalGames.g:8694:2: ( ruleCondition )
            // InternalGames.g:8695:3: ruleCondition
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsActiveConditionParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getKnowledgeAccess().getConditionsActiveConditionParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__ConditionsActiveAssignment_10_1"


    // $ANTLR start "rule__Knowledge__ConditionsGiveAssignment_11_1"
    // InternalGames.g:8704:1: rule__Knowledge__ConditionsGiveAssignment_11_1 : ( ruleCondition ) ;
    public final void rule__Knowledge__ConditionsGiveAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8708:1: ( ( ruleCondition ) )
            // InternalGames.g:8709:2: ( ruleCondition )
            {
            // InternalGames.g:8709:2: ( ruleCondition )
            // InternalGames.g:8710:3: ruleCondition
            {
             before(grammarAccess.getKnowledgeAccess().getConditionsGiveConditionParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getKnowledgeAccess().getConditionsGiveConditionParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Knowledge__ConditionsGiveAssignment_11_1"


    // $ANTLR start "rule__Place__NameAssignment_1"
    // InternalGames.g:8719:1: rule__Place__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Place__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8723:1: ( ( RULE_ID ) )
            // InternalGames.g:8724:2: ( RULE_ID )
            {
            // InternalGames.g:8724:2: ( RULE_ID )
            // InternalGames.g:8725:3: RULE_ID
            {
             before(grammarAccess.getPlaceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__NameAssignment_1"


    // $ANTLR start "rule__Place__KnowledgesAssignment_3_1"
    // InternalGames.g:8734:1: rule__Place__KnowledgesAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Place__KnowledgesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8738:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8739:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8739:2: ( ( RULE_ID ) )
            // InternalGames.g:8740:3: ( RULE_ID )
            {
             before(grammarAccess.getPlaceAccess().getKnowledgesKnowledgeCrossReference_3_1_0()); 
            // InternalGames.g:8741:3: ( RULE_ID )
            // InternalGames.g:8742:4: RULE_ID
            {
             before(grammarAccess.getPlaceAccess().getKnowledgesKnowledgeIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getKnowledgesKnowledgeIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getPlaceAccess().getKnowledgesKnowledgeCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__KnowledgesAssignment_3_1"


    // $ANTLR start "rule__Place__PeopleAssignment_4_1"
    // InternalGames.g:8753:1: rule__Place__PeopleAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Place__PeopleAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8757:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8758:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8758:2: ( ( RULE_ID ) )
            // InternalGames.g:8759:3: ( RULE_ID )
            {
             before(grammarAccess.getPlaceAccess().getPeoplePeopleCrossReference_4_1_0()); 
            // InternalGames.g:8760:3: ( RULE_ID )
            // InternalGames.g:8761:4: RULE_ID
            {
             before(grammarAccess.getPlaceAccess().getPeoplePeopleIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getPeoplePeopleIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getPlaceAccess().getPeoplePeopleCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__PeopleAssignment_4_1"


    // $ANTLR start "rule__Place__PathsAssignment_5_1"
    // InternalGames.g:8772:1: rule__Place__PathsAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Place__PathsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8776:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8777:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8777:2: ( ( RULE_ID ) )
            // InternalGames.g:8778:3: ( RULE_ID )
            {
             before(grammarAccess.getPlaceAccess().getPathsPathCrossReference_5_1_0()); 
            // InternalGames.g:8779:3: ( RULE_ID )
            // InternalGames.g:8780:4: RULE_ID
            {
             before(grammarAccess.getPlaceAccess().getPathsPathIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPlaceAccess().getPathsPathIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getPlaceAccess().getPathsPathCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__PathsAssignment_5_1"


    // $ANTLR start "rule__Place__ObjectsAssignment_6_1"
    // InternalGames.g:8791:1: rule__Place__ObjectsAssignment_6_1 : ( ruleItemInSomething ) ;
    public final void rule__Place__ObjectsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8795:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8796:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8796:2: ( ruleItemInSomething )
            // InternalGames.g:8797:3: ruleItemInSomething
            {
             before(grammarAccess.getPlaceAccess().getObjectsItemInSomethingParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getPlaceAccess().getObjectsItemInSomethingParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Place__ObjectsAssignment_6_1"


    // $ANTLR start "rule__ItemInCondition__ItemAssignment_0"
    // InternalGames.g:8806:1: rule__ItemInCondition__ItemAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ItemInCondition__ItemAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8810:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8811:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8811:2: ( ( RULE_ID ) )
            // InternalGames.g:8812:3: ( RULE_ID )
            {
             before(grammarAccess.getItemInConditionAccess().getItemItemCrossReference_0_0()); 
            // InternalGames.g:8813:3: ( RULE_ID )
            // InternalGames.g:8814:4: RULE_ID
            {
             before(grammarAccess.getItemInConditionAccess().getItemItemIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getItemInConditionAccess().getItemItemIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getItemInConditionAccess().getItemItemCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__ItemAssignment_0"


    // $ANTLR start "rule__ItemInCondition__QuantityAssignment_2"
    // InternalGames.g:8825:1: rule__ItemInCondition__QuantityAssignment_2 : ( RULE_INT ) ;
    public final void rule__ItemInCondition__QuantityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8829:1: ( ( RULE_INT ) )
            // InternalGames.g:8830:2: ( RULE_INT )
            {
            // InternalGames.g:8830:2: ( RULE_INT )
            // InternalGames.g:8831:3: RULE_INT
            {
             before(grammarAccess.getItemInConditionAccess().getQuantityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemInConditionAccess().getQuantityINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__QuantityAssignment_2"


    // $ANTLR start "rule__ItemInCondition__MustBeExactAssignment_4"
    // InternalGames.g:8840:1: rule__ItemInCondition__MustBeExactAssignment_4 : ( RULE_INT ) ;
    public final void rule__ItemInCondition__MustBeExactAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8844:1: ( ( RULE_INT ) )
            // InternalGames.g:8845:2: ( RULE_INT )
            {
            // InternalGames.g:8845:2: ( RULE_INT )
            // InternalGames.g:8846:3: RULE_INT
            {
             before(grammarAccess.getItemInConditionAccess().getMustBeExactINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getItemInConditionAccess().getMustBeExactINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemInCondition__MustBeExactAssignment_4"


    // $ANTLR start "rule__Condition__NameAssignment_1"
    // InternalGames.g:8855:1: rule__Condition__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Condition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8859:1: ( ( RULE_STRING ) )
            // InternalGames.g:8860:2: ( RULE_STRING )
            {
            // InternalGames.g:8860:2: ( RULE_STRING )
            // InternalGames.g:8861:3: RULE_STRING
            {
             before(grammarAccess.getConditionAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__NameAssignment_1"


    // $ANTLR start "rule__Condition__PlayerAssignment_4"
    // InternalGames.g:8870:1: rule__Condition__PlayerAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__PlayerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8874:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8875:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8875:2: ( ( RULE_ID ) )
            // InternalGames.g:8876:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getPlayerPlayerCrossReference_4_0()); 
            // InternalGames.g:8877:3: ( RULE_ID )
            // InternalGames.g:8878:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getPlayerPlayerIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getPlayerPlayerIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getPlayerPlayerCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__PlayerAssignment_4"


    // $ANTLR start "rule__Condition__KnowAssignment_5_1"
    // InternalGames.g:8889:1: rule__Condition__KnowAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Condition__KnowAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8893:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8894:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8894:2: ( ( RULE_ID ) )
            // InternalGames.g:8895:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionAccess().getKnowKnowledgeCrossReference_5_1_0()); 
            // InternalGames.g:8896:3: ( RULE_ID )
            // InternalGames.g:8897:4: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getKnowKnowledgeIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getKnowKnowledgeIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getConditionAccess().getKnowKnowledgeCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__KnowAssignment_5_1"


    // $ANTLR start "rule__Condition__ItemAssignment_6_1"
    // InternalGames.g:8908:1: rule__Condition__ItemAssignment_6_1 : ( ruleItemInCondition ) ;
    public final void rule__Condition__ItemAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8912:1: ( ( ruleItemInCondition ) )
            // InternalGames.g:8913:2: ( ruleItemInCondition )
            {
            // InternalGames.g:8913:2: ( ruleItemInCondition )
            // InternalGames.g:8914:3: ruleItemInCondition
            {
             before(grammarAccess.getConditionAccess().getItemItemInConditionParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInCondition();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getItemItemInConditionParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ItemAssignment_6_1"


    // $ANTLR start "rule__Action__NameAssignment_1"
    // InternalGames.g:8923:1: rule__Action__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Action__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8927:1: ( ( RULE_ID ) )
            // InternalGames.g:8928:2: ( RULE_ID )
            {
            // InternalGames.g:8928:2: ( RULE_ID )
            // InternalGames.g:8929:3: RULE_ID
            {
             before(grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__NameAssignment_1"


    // $ANTLR start "rule__Action__ValAssignment_4"
    // InternalGames.g:8938:1: rule__Action__ValAssignment_4 : ( ruleActions ) ;
    public final void rule__Action__ValAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8942:1: ( ( ruleActions ) )
            // InternalGames.g:8943:2: ( ruleActions )
            {
            // InternalGames.g:8943:2: ( ruleActions )
            // InternalGames.g:8944:3: ruleActions
            {
             before(grammarAccess.getActionAccess().getValActionsEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleActions();

            state._fsp--;

             after(grammarAccess.getActionAccess().getValActionsEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ValAssignment_4"


    // $ANTLR start "rule__Action__InterSuivanteAssignment_6"
    // InternalGames.g:8953:1: rule__Action__InterSuivanteAssignment_6 : ( ruleInteraction ) ;
    public final void rule__Action__InterSuivanteAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8957:1: ( ( ruleInteraction ) )
            // InternalGames.g:8958:2: ( ruleInteraction )
            {
            // InternalGames.g:8958:2: ( ruleInteraction )
            // InternalGames.g:8959:3: ruleInteraction
            {
             before(grammarAccess.getActionAccess().getInterSuivanteInteractionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleInteraction();

            state._fsp--;

             after(grammarAccess.getActionAccess().getInterSuivanteInteractionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__InterSuivanteAssignment_6"


    // $ANTLR start "rule__Action__KnowledgeGivenAssignment_7_1"
    // InternalGames.g:8968:1: rule__Action__KnowledgeGivenAssignment_7_1 : ( ( RULE_ID ) ) ;
    public final void rule__Action__KnowledgeGivenAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8972:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:8973:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:8973:2: ( ( RULE_ID ) )
            // InternalGames.g:8974:3: ( RULE_ID )
            {
             before(grammarAccess.getActionAccess().getKnowledgeGivenKnowledgeCrossReference_7_1_0()); 
            // InternalGames.g:8975:3: ( RULE_ID )
            // InternalGames.g:8976:4: RULE_ID
            {
             before(grammarAccess.getActionAccess().getKnowledgeGivenKnowledgeIDTerminalRuleCall_7_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getKnowledgeGivenKnowledgeIDTerminalRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getActionAccess().getKnowledgeGivenKnowledgeCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__KnowledgeGivenAssignment_7_1"


    // $ANTLR start "rule__Action__ItemsGivenAssignment_8_1"
    // InternalGames.g:8987:1: rule__Action__ItemsGivenAssignment_8_1 : ( ruleItemInSomething ) ;
    public final void rule__Action__ItemsGivenAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:8991:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:8992:2: ( ruleItemInSomething )
            {
            // InternalGames.g:8992:2: ( ruleItemInSomething )
            // InternalGames.g:8993:3: ruleItemInSomething
            {
             before(grammarAccess.getActionAccess().getItemsGivenItemInSomethingParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getActionAccess().getItemsGivenItemInSomethingParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ItemsGivenAssignment_8_1"


    // $ANTLR start "rule__Action__ItemsConsumedAssignment_9_1"
    // InternalGames.g:9002:1: rule__Action__ItemsConsumedAssignment_9_1 : ( ruleItemInSomething ) ;
    public final void rule__Action__ItemsConsumedAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9006:1: ( ( ruleItemInSomething ) )
            // InternalGames.g:9007:2: ( ruleItemInSomething )
            {
            // InternalGames.g:9007:2: ( ruleItemInSomething )
            // InternalGames.g:9008:3: ruleItemInSomething
            {
             before(grammarAccess.getActionAccess().getItemsConsumedItemInSomethingParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleItemInSomething();

            state._fsp--;

             after(grammarAccess.getActionAccess().getItemsConsumedItemInSomethingParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ItemsConsumedAssignment_9_1"


    // $ANTLR start "rule__Action__ConditionsActionsAvailableAssignment_10_1"
    // InternalGames.g:9017:1: rule__Action__ConditionsActionsAvailableAssignment_10_1 : ( ruleCondition ) ;
    public final void rule__Action__ConditionsActionsAvailableAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9021:1: ( ( ruleCondition ) )
            // InternalGames.g:9022:2: ( ruleCondition )
            {
            // InternalGames.g:9022:2: ( ruleCondition )
            // InternalGames.g:9023:3: ruleCondition
            {
             before(grammarAccess.getActionAccess().getConditionsActionsAvailableConditionParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getActionAccess().getConditionsActionsAvailableConditionParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__ConditionsActionsAvailableAssignment_10_1"


    // $ANTLR start "rule__Action__GameAssignment_12"
    // InternalGames.g:9032:1: rule__Action__GameAssignment_12 : ( ( RULE_ID ) ) ;
    public final void rule__Action__GameAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9036:1: ( ( ( RULE_ID ) ) )
            // InternalGames.g:9037:2: ( ( RULE_ID ) )
            {
            // InternalGames.g:9037:2: ( ( RULE_ID ) )
            // InternalGames.g:9038:3: ( RULE_ID )
            {
             before(grammarAccess.getActionAccess().getGameGameCrossReference_12_0()); 
            // InternalGames.g:9039:3: ( RULE_ID )
            // InternalGames.g:9040:4: RULE_ID
            {
             before(grammarAccess.getActionAccess().getGameGameIDTerminalRuleCall_12_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionAccess().getGameGameIDTerminalRuleCall_12_0_1()); 

            }

             after(grammarAccess.getActionAccess().getGameGameCrossReference_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__GameAssignment_12"


    // $ANTLR start "rule__Interaction__NameAssignment_1"
    // InternalGames.g:9051:1: rule__Interaction__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Interaction__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9055:1: ( ( RULE_STRING ) )
            // InternalGames.g:9056:2: ( RULE_STRING )
            {
            // InternalGames.g:9056:2: ( RULE_STRING )
            // InternalGames.g:9057:3: RULE_STRING
            {
             before(grammarAccess.getInteractionAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInteractionAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__NameAssignment_1"


    // $ANTLR start "rule__Interaction__PropAssignment_5"
    // InternalGames.g:9066:1: rule__Interaction__PropAssignment_5 : ( ruleProposition ) ;
    public final void rule__Interaction__PropAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9070:1: ( ( ruleProposition ) )
            // InternalGames.g:9071:2: ( ruleProposition )
            {
            // InternalGames.g:9071:2: ( ruleProposition )
            // InternalGames.g:9072:3: ruleProposition
            {
             before(grammarAccess.getInteractionAccess().getPropPropositionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getPropPropositionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__PropAssignment_5"


    // $ANTLR start "rule__Interaction__ConditionsBeginAssignment_7_1"
    // InternalGames.g:9081:1: rule__Interaction__ConditionsBeginAssignment_7_1 : ( ruleCondition ) ;
    public final void rule__Interaction__ConditionsBeginAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9085:1: ( ( ruleCondition ) )
            // InternalGames.g:9086:2: ( ruleCondition )
            {
            // InternalGames.g:9086:2: ( ruleCondition )
            // InternalGames.g:9087:3: ruleCondition
            {
             before(grammarAccess.getInteractionAccess().getConditionsBeginConditionParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getConditionsBeginConditionParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ConditionsBeginAssignment_7_1"


    // $ANTLR start "rule__Interaction__ConditionsEndAssignment_8_1"
    // InternalGames.g:9096:1: rule__Interaction__ConditionsEndAssignment_8_1 : ( ruleCondition ) ;
    public final void rule__Interaction__ConditionsEndAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9100:1: ( ( ruleCondition ) )
            // InternalGames.g:9101:2: ( ruleCondition )
            {
            // InternalGames.g:9101:2: ( ruleCondition )
            // InternalGames.g:9102:3: ruleCondition
            {
             before(grammarAccess.getInteractionAccess().getConditionsEndConditionParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getInteractionAccess().getConditionsEndConditionParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interaction__ConditionsEndAssignment_8_1"


    // $ANTLR start "rule__Proposition__ValueAssignment_3"
    // InternalGames.g:9111:1: rule__Proposition__ValueAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Proposition__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9115:1: ( ( RULE_STRING ) )
            // InternalGames.g:9116:2: ( RULE_STRING )
            {
            // InternalGames.g:9116:2: ( RULE_STRING )
            // InternalGames.g:9117:3: RULE_STRING
            {
             before(grammarAccess.getPropositionAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getValueSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__ValueAssignment_3"


    // $ANTLR start "rule__Proposition__ActAssignment_4"
    // InternalGames.g:9126:1: rule__Proposition__ActAssignment_4 : ( ruleAction ) ;
    public final void rule__Proposition__ActAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGames.g:9130:1: ( ( ruleAction ) )
            // InternalGames.g:9131:2: ( ruleAction )
            {
            // InternalGames.g:9131:2: ( ruleAction )
            // InternalGames.g:9132:3: ruleAction
            {
             before(grammarAccess.getPropositionAccess().getActActionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getPropositionAccess().getActActionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__ActAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000010C000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004001000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000022000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00001C0100000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0800800000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0007000100000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0180000000000010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0002008100000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x040000010C200000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x000000000000F800L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x8000180000010000L,0x0000000000000003L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x1000000000000000L});

}