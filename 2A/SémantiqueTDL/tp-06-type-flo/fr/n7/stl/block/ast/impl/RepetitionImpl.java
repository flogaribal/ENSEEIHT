/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a repetition instruction.
 * @author Marc Pantel
 *
 */
public class RepetitionImpl implements Instruction {

	private Expression condition;
	private Block body;

	public RepetitionImpl(Expression _condition, Block _body) {
		this.condition = _condition;
		this.body = _body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "while (" + this.condition + ") " + this.body;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean res = condition.getType().equalsTo(AtomicType.BooleanType) &&  body.checkType(); 

		return res;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		body.allocateMemory(_register,_offset);
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		int numBoucle = _factory.createLabelNumber();

		// Elaboration condition
		fragment.append(condition.getCode(_factory));
		
		// Label début boucle
		fragment.addPrefix("debut_boucle_"+numBoucle+":");

		// Go fin boucle si condition fausse
		fragment.add(_factory.createJumpIf("fin_boucle_"+numBoucle, 0));

		// Code de corps de boucle
		fragment.append(body.getCode(_factory));		

		// Go début de boucle dans tous les cas
		fragment.add(_factory.createJump("debut_boucle_"+numBoucle));

		// Label fin de boucle
		fragment.addSuffix("fin_boucle_"+numBoucle+":");

		return fragment;
	}

}
