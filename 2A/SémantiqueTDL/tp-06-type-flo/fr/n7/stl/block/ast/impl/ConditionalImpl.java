/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class ConditionalImpl implements Instruction {

	private Expression condition;
	private Block thenBranch;
	private Optional<Block> elseBranch;

	public ConditionalImpl(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.of(_else);
	}

	public ConditionalImpl(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch.isPresent())?(" else " + this.elseBranch.get()):"");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean res = condition.getType().equalsTo(AtomicType.BooleanType) &&  thenBranch.checkType(); 

		if(elseBranch.isPresent())		{
			res &= elseBranch.get().checkType();
		}

		return res;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		thenBranch.allocateMemory(_register,_offset);

		if (elseBranch.isPresent()) {
			elseBranch.get().allocateMemory(_register,_offset);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		int numCond = _factory.createLabelNumber();

		// Elaboration condition
		fragment.append(condition.getCode(_factory));

		// Test condition
		fragment.add(_factory.createJumpIf("else_cond_"+numCond, 0));

		// Branche if
		fragment.append(thenBranch.getCode(_factory));

		// Jump fin condition car passé dans if
		fragment.add(_factory.createJump("fin_cond_"+numCond));

		// Label début branche else
		fragment.addSuffix("else_cond_"+numCond+":");

		// Branche else si présente
		if (elseBranch.isPresent()){
			fragment.append(elseBranch.get().getCode(_factory));
		} 
		
		// Label fin condition
		fragment.addSuffix("fin_cond_"+numCond+":");

		return fragment;
	}

}
