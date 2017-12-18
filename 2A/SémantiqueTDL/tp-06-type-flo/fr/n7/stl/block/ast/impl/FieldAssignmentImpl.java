/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.impl.FieldAssignmentImpl;
import fr.n7.stl.block.ast.impl.VariableAssignmentImpl;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.block.ast.Type;

/**
 * @author Marc Pantel
 *
 */
public class FieldAssignmentImpl extends FieldAccessImpl implements Assignable {


	/**
	 * @param _record
	 * @param _name
	 */
	public FieldAssignmentImpl(Expression _record, String _name) {
		super(_record, _name);
	}

	/**
	 * @param _record
	 * @param _field
	 */
	public FieldAssignmentImpl(Expression _record, FieldDeclaration _field) {
		super(_record, _field);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		int offset = 0;

		offset = getFieldAssignmentOffset(this);
		Register reg = getFieldAssignmentRegister(this);

		fragment.add(_factory.createLoadA(reg, offset));

		return fragment;
	}	


// TODO : une seule récursion stp
	private int getFieldAssignmentOffset(FieldAssignmentImpl fieldAssignment) {
		int offset = 0;

		int recordLength = fieldAssignment.record.getType().length();
		Type type = fieldAssignment.getType();
		int fieldOffset = fieldAssignment.getFieldOffset();

		offset = recordLength - fieldOffset - type.length();

		if (fieldAssignment.record instanceof FieldAssignmentImpl) {
			offset += getFieldAssignmentOffset((FieldAssignmentImpl) fieldAssignment.record);
		}


		return offset;
	}

	private Register getFieldAssignmentRegister(FieldAssignmentImpl fieldAssignment) {

		if (fieldAssignment.record instanceof FieldAssignmentImpl) {
			return getFieldAssignmentRegister((FieldAssignmentImpl) fieldAssignment.record);
		}
		else {
			return ((VariableAssignmentImpl) fieldAssignment.record).declaration.getRegister();
		}
	}

}


