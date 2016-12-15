/**
 */
package simplepdl.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import simplepdl.Guidance;
import simplepdl.ProcessElement;
import simplepdl.Resource;
import simplepdl.SimplepdlPackage;
import simplepdl.UseResources;
import simplepdl.WorkDefinition;
import simplepdl.WorkSequence;
import simplepdl.WorkSequenceType;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see simplepdl.SimplepdlPackage
 * @generated
 */
public class SimplepdlValidator extends OCLinEcoreEObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SimplepdlValidator INSTANCE = new SimplepdlValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "simplepdl";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplepdlValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return SimplepdlPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case SimplepdlPackage.PROCESS:
				return validateProcess((simplepdl.Process)value, diagnostics, context);
			case SimplepdlPackage.PROCESS_ELEMENT:
				return validateProcessElement((ProcessElement)value, diagnostics, context);
			case SimplepdlPackage.WORK_DEFINITION:
				return validateWorkDefinition((WorkDefinition)value, diagnostics, context);
			case SimplepdlPackage.WORK_SEQUENCE:
				return validateWorkSequence((WorkSequence)value, diagnostics, context);
			case SimplepdlPackage.GUIDANCE:
				return validateGuidance((Guidance)value, diagnostics, context);
			case SimplepdlPackage.RESOURCE:
				return validateResource((Resource)value, diagnostics, context);
			case SimplepdlPackage.USE_RESOURCES:
				return validateUseResources((UseResources)value, diagnostics, context);
			case SimplepdlPackage.WORK_SEQUENCE_TYPE:
				return validateWorkSequenceType((WorkSequenceType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(simplepdl.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(process, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(process, diagnostics, context);
		if (result || diagnostics != null) result &= validateProcess_nomDifferent(process, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the nomDifferent constraint of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PROCESS__NOM_DIFFERENT__EEXPRESSION = "Process.allInstances()\n" +
		"\t\t\t->select(i | i.oclIsTypeOf(WorkDefinition))\n" +
		"\t\t\t->forAll(i,j | i<>j implies i.name <> j.name)";

	/**
	 * Validates the nomDifferent constraint of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess_nomDifferent(simplepdl.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.PROCESS,
				 process,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "nomDifferent",
				 PROCESS__NOM_DIFFERENT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessElement(ProcessElement processElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkDefinition(WorkDefinition workDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(workDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(workDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkDefinition_oneChar(workDefinition, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneChar constraint of '<em>Work Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORK_DEFINITION__ONE_CHAR__EEXPRESSION = "self.name <> ''";

	/**
	 * Validates the oneChar constraint of '<em>Work Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkDefinition_oneChar(WorkDefinition workDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.WORK_DEFINITION,
				 workDefinition,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneChar",
				 WORK_DEFINITION__ONE_CHAR__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkSequence(WorkSequence workSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(workSequence, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkSequence_previousWDinSameProcess(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkSequence_nextWDinSameProcess(workSequence, diagnostics, context);
		if (result || diagnostics != null) result &= validateWorkSequence_nonReflexive(workSequence, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the previousWDinSameProcess constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORK_SEQUENCE__PREVIOUS_WDIN_SAME_PROCESS__EEXPRESSION = "self.process = self.predecessor.process";

	/**
	 * Validates the previousWDinSameProcess constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkSequence_previousWDinSameProcess(WorkSequence workSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.WORK_SEQUENCE,
				 workSequence,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "previousWDinSameProcess",
				 WORK_SEQUENCE__PREVIOUS_WDIN_SAME_PROCESS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the nextWDinSameProcess constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORK_SEQUENCE__NEXT_WDIN_SAME_PROCESS__EEXPRESSION = "self.process = self.successor.process";

	/**
	 * Validates the nextWDinSameProcess constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkSequence_nextWDinSameProcess(WorkSequence workSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.WORK_SEQUENCE,
				 workSequence,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "nextWDinSameProcess",
				 WORK_SEQUENCE__NEXT_WDIN_SAME_PROCESS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the nonReflexive constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String WORK_SEQUENCE__NON_REFLEXIVE__EEXPRESSION = "self.successor <> self.predecessor";

	/**
	 * Validates the nonReflexive constraint of '<em>Work Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkSequence_nonReflexive(WorkSequence workSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.WORK_SEQUENCE,
				 workSequence,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "nonReflexive",
				 WORK_SEQUENCE__NON_REFLEXIVE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuidance(Guidance guidance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(guidance, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResource(Resource resource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(resource, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resource, diagnostics, context);
		if (result || diagnostics != null) result &= validateResource_nameNotEmpty(resource, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the nameNotEmpty constraint of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String RESOURCE__NAME_NOT_EMPTY__EEXPRESSION = "self.name <> null and self.name <> ''";

	/**
	 * Validates the nameNotEmpty constraint of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResource_nameNotEmpty(Resource resource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.RESOURCE,
				 resource,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "nameNotEmpty",
				 RESOURCE__NAME_NOT_EMPTY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseResources(UseResources useResources, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(useResources, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseResources_correctWeight(useResources, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseResources_positiveWeight(useResources, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the correctWeight constraint of '<em>Use Resources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String USE_RESOURCES__CORRECT_WEIGHT__EEXPRESSION = "self.weight <= self.usedResource.quantity";

	/**
	 * Validates the correctWeight constraint of '<em>Use Resources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseResources_correctWeight(UseResources useResources, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.USE_RESOURCES,
				 useResources,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "correctWeight",
				 USE_RESOURCES__CORRECT_WEIGHT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the positiveWeight constraint of '<em>Use Resources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String USE_RESOURCES__POSITIVE_WEIGHT__EEXPRESSION = "self.weight >= 0";

	/**
	 * Validates the positiveWeight constraint of '<em>Use Resources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseResources_positiveWeight(UseResources useResources, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(SimplepdlPackage.Literals.USE_RESOURCES,
				 useResources,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "positiveWeight",
				 USE_RESOURCES__POSITIVE_WEIGHT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWorkSequenceType(WorkSequenceType workSequenceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //SimplepdlValidator
