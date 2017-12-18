/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.ConstantDeclaration;
import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.TypeDeclaration;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import java.util.*;

import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an instruction block.
 * @author Marc Pantel
 *
 */
public class BlockImpl implements Block {

	/**
	 * Sequence of instructions contained in a block.
	 */
	private List<Instruction> instructions;

	private int  allocatedSize; 
	/**
	 * Hierarchical structure of blocks.
	 * Link to the container block.
	 * 
	 */
	private Optional<Block> context;
	
	/**
	 * Constructor for a block contained in a _context block.
	 * @param _context Englobing block.
	 */
	public BlockImpl(Block _context) {
		assert( _context != null);
		this.instructions = new LinkedList<Instruction>();
		if (_context == null) {
			this.context = Optional.empty();
		} else {
			this.context = Optional.of(_context);
		}
		this.allocatedSize = 0;
	}
	
	/**
	 * Constructor for a block root of the block hierarchy.
	 */
	public BlockImpl() {
		this.instructions = new LinkedList<Instruction>();
		this.context = Optional.empty();
		this.allocatedSize = 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.Block#add(fr.n7.block.ast.Instruction)
	 */
	@Override
	public void add(Instruction _instruction) {
		this.instructions.add(_instruction);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#addAll(java.lang.Iterable)
	 */
	@Override
	public void addAll(Iterable<Instruction> _instructions) {
		for (Instruction i : _instructions) {
			this.instructions.add(i);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _local = "";
		for (Instruction _instruction : this.instructions) {
			_local +=_instruction;
		}
		return "{\n" + _local + "}\n" ;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		// throw new SemanticsUndefinedException("Semantics checkType is undefined in BlockImpl.");
		boolean _result = true;
		for (Instruction _instruction : this.instructions) {
			_result = _result && _instruction.checkType();
		}
		return _result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		int local = _offset;

		//LinkedList<Instruction> reversedList = new LinkedList<Instruction>(instructions);
		//Collections.reverse(reversedList) ;

		for(Instruction i : instructions) {
			local += i.allocateMemory(_register,local);
		}

		this.allocatedSize = local-_offset;
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		//LinkedList<Instruction> reversedList = new LinkedList<Instruction>(instructions);
		//Collections.reverse(reversedList) ;

		for (Instruction i : instructions) {
			fragment.append(i.getCode(_factory));
		}


		// POP (allocatedSize) 0 ?
		return fragment;
	}	

}
