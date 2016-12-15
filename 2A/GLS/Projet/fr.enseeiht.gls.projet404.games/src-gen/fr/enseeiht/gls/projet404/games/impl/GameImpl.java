/**
 * generated by Xtext 2.10.0
 */
package fr.enseeiht.gls.projet404.games.impl;

import fr.enseeiht.gls.projet404.games.Difficulty;
import fr.enseeiht.gls.projet404.games.Game;
import fr.enseeiht.gls.projet404.games.GamesPackage;
import fr.enseeiht.gls.projet404.games.Item;
import fr.enseeiht.gls.projet404.games.Knowledge;
import fr.enseeiht.gls.projet404.games.Path;
import fr.enseeiht.gls.projet404.games.People;
import fr.enseeiht.gls.projet404.games.Place;
import fr.enseeiht.gls.projet404.games.Player;
import fr.enseeiht.gls.projet404.games.Recipe;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getPlaces <em>Places</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getKnowledge <em>Knowledge</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getPeople <em>People</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getItems <em>Items</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getPath <em>Path</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getRecipes <em>Recipes</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getStartPlace <em>Start Place</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getEndPlace <em>End Place</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.GameImpl#getDifficulty <em>Difficulty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameImpl extends MinimalEObjectImpl.Container implements Game
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getPlayer() <em>Player</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlayer()
   * @generated
   * @ordered
   */
  protected Player player;

  /**
   * The cached value of the '{@link #getPlaces() <em>Places</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlaces()
   * @generated
   * @ordered
   */
  protected EList<Place> places;

  /**
   * The cached value of the '{@link #getKnowledge() <em>Knowledge</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKnowledge()
   * @generated
   * @ordered
   */
  protected EList<Knowledge> knowledge;

  /**
   * The cached value of the '{@link #getPeople() <em>People</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeople()
   * @generated
   * @ordered
   */
  protected EList<People> people;

  /**
   * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItems()
   * @generated
   * @ordered
   */
  protected EList<Item> items;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected EList<Path> path;

  /**
   * The cached value of the '{@link #getRecipes() <em>Recipes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecipes()
   * @generated
   * @ordered
   */
  protected EList<Recipe> recipes;

  /**
   * The cached value of the '{@link #getStartPlace() <em>Start Place</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPlace()
   * @generated
   * @ordered
   */
  protected Place startPlace;

  /**
   * The cached value of the '{@link #getEndPlace() <em>End Place</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndPlace()
   * @generated
   * @ordered
   */
  protected EList<Place> endPlace;

  /**
   * The cached value of the '{@link #getDifficulty() <em>Difficulty</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDifficulty()
   * @generated
   * @ordered
   */
  protected Difficulty difficulty;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GamesPackage.Literals.GAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Player getPlayer()
  {
    return player;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPlayer(Player newPlayer, NotificationChain msgs)
  {
    Player oldPlayer = player;
    player = newPlayer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__PLAYER, oldPlayer, newPlayer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlayer(Player newPlayer)
  {
    if (newPlayer != player)
    {
      NotificationChain msgs = null;
      if (player != null)
        msgs = ((InternalEObject)player).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GamesPackage.GAME__PLAYER, null, msgs);
      if (newPlayer != null)
        msgs = ((InternalEObject)newPlayer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GamesPackage.GAME__PLAYER, null, msgs);
      msgs = basicSetPlayer(newPlayer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__PLAYER, newPlayer, newPlayer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Place> getPlaces()
  {
    if (places == null)
    {
      places = new EObjectContainmentEList<Place>(Place.class, this, GamesPackage.GAME__PLACES);
    }
    return places;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Knowledge> getKnowledge()
  {
    if (knowledge == null)
    {
      knowledge = new EObjectContainmentEList<Knowledge>(Knowledge.class, this, GamesPackage.GAME__KNOWLEDGE);
    }
    return knowledge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<People> getPeople()
  {
    if (people == null)
    {
      people = new EObjectContainmentEList<People>(People.class, this, GamesPackage.GAME__PEOPLE);
    }
    return people;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Item> getItems()
  {
    if (items == null)
    {
      items = new EObjectContainmentEList<Item>(Item.class, this, GamesPackage.GAME__ITEMS);
    }
    return items;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Path> getPath()
  {
    if (path == null)
    {
      path = new EObjectContainmentEList<Path>(Path.class, this, GamesPackage.GAME__PATH);
    }
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Recipe> getRecipes()
  {
    if (recipes == null)
    {
      recipes = new EObjectContainmentEList<Recipe>(Recipe.class, this, GamesPackage.GAME__RECIPES);
    }
    return recipes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Place getStartPlace()
  {
    if (startPlace != null && startPlace.eIsProxy())
    {
      InternalEObject oldStartPlace = (InternalEObject)startPlace;
      startPlace = (Place)eResolveProxy(oldStartPlace);
      if (startPlace != oldStartPlace)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GamesPackage.GAME__START_PLACE, oldStartPlace, startPlace));
      }
    }
    return startPlace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Place basicGetStartPlace()
  {
    return startPlace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartPlace(Place newStartPlace)
  {
    Place oldStartPlace = startPlace;
    startPlace = newStartPlace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__START_PLACE, oldStartPlace, startPlace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Place> getEndPlace()
  {
    if (endPlace == null)
    {
      endPlace = new EObjectResolvingEList<Place>(Place.class, this, GamesPackage.GAME__END_PLACE);
    }
    return endPlace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Difficulty getDifficulty()
  {
    return difficulty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDifficulty(Difficulty newDifficulty, NotificationChain msgs)
  {
    Difficulty oldDifficulty = difficulty;
    difficulty = newDifficulty;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__DIFFICULTY, oldDifficulty, newDifficulty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDifficulty(Difficulty newDifficulty)
  {
    if (newDifficulty != difficulty)
    {
      NotificationChain msgs = null;
      if (difficulty != null)
        msgs = ((InternalEObject)difficulty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GamesPackage.GAME__DIFFICULTY, null, msgs);
      if (newDifficulty != null)
        msgs = ((InternalEObject)newDifficulty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GamesPackage.GAME__DIFFICULTY, null, msgs);
      msgs = basicSetDifficulty(newDifficulty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.GAME__DIFFICULTY, newDifficulty, newDifficulty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GamesPackage.GAME__PLAYER:
        return basicSetPlayer(null, msgs);
      case GamesPackage.GAME__PLACES:
        return ((InternalEList<?>)getPlaces()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__KNOWLEDGE:
        return ((InternalEList<?>)getKnowledge()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__PEOPLE:
        return ((InternalEList<?>)getPeople()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__ITEMS:
        return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__PATH:
        return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__RECIPES:
        return ((InternalEList<?>)getRecipes()).basicRemove(otherEnd, msgs);
      case GamesPackage.GAME__DIFFICULTY:
        return basicSetDifficulty(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GamesPackage.GAME__NAME:
        return getName();
      case GamesPackage.GAME__PLAYER:
        return getPlayer();
      case GamesPackage.GAME__PLACES:
        return getPlaces();
      case GamesPackage.GAME__KNOWLEDGE:
        return getKnowledge();
      case GamesPackage.GAME__PEOPLE:
        return getPeople();
      case GamesPackage.GAME__ITEMS:
        return getItems();
      case GamesPackage.GAME__PATH:
        return getPath();
      case GamesPackage.GAME__RECIPES:
        return getRecipes();
      case GamesPackage.GAME__START_PLACE:
        if (resolve) return getStartPlace();
        return basicGetStartPlace();
      case GamesPackage.GAME__END_PLACE:
        return getEndPlace();
      case GamesPackage.GAME__DIFFICULTY:
        return getDifficulty();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GamesPackage.GAME__NAME:
        setName((String)newValue);
        return;
      case GamesPackage.GAME__PLAYER:
        setPlayer((Player)newValue);
        return;
      case GamesPackage.GAME__PLACES:
        getPlaces().clear();
        getPlaces().addAll((Collection<? extends Place>)newValue);
        return;
      case GamesPackage.GAME__KNOWLEDGE:
        getKnowledge().clear();
        getKnowledge().addAll((Collection<? extends Knowledge>)newValue);
        return;
      case GamesPackage.GAME__PEOPLE:
        getPeople().clear();
        getPeople().addAll((Collection<? extends People>)newValue);
        return;
      case GamesPackage.GAME__ITEMS:
        getItems().clear();
        getItems().addAll((Collection<? extends Item>)newValue);
        return;
      case GamesPackage.GAME__PATH:
        getPath().clear();
        getPath().addAll((Collection<? extends Path>)newValue);
        return;
      case GamesPackage.GAME__RECIPES:
        getRecipes().clear();
        getRecipes().addAll((Collection<? extends Recipe>)newValue);
        return;
      case GamesPackage.GAME__START_PLACE:
        setStartPlace((Place)newValue);
        return;
      case GamesPackage.GAME__END_PLACE:
        getEndPlace().clear();
        getEndPlace().addAll((Collection<? extends Place>)newValue);
        return;
      case GamesPackage.GAME__DIFFICULTY:
        setDifficulty((Difficulty)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GamesPackage.GAME__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GamesPackage.GAME__PLAYER:
        setPlayer((Player)null);
        return;
      case GamesPackage.GAME__PLACES:
        getPlaces().clear();
        return;
      case GamesPackage.GAME__KNOWLEDGE:
        getKnowledge().clear();
        return;
      case GamesPackage.GAME__PEOPLE:
        getPeople().clear();
        return;
      case GamesPackage.GAME__ITEMS:
        getItems().clear();
        return;
      case GamesPackage.GAME__PATH:
        getPath().clear();
        return;
      case GamesPackage.GAME__RECIPES:
        getRecipes().clear();
        return;
      case GamesPackage.GAME__START_PLACE:
        setStartPlace((Place)null);
        return;
      case GamesPackage.GAME__END_PLACE:
        getEndPlace().clear();
        return;
      case GamesPackage.GAME__DIFFICULTY:
        setDifficulty((Difficulty)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GamesPackage.GAME__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GamesPackage.GAME__PLAYER:
        return player != null;
      case GamesPackage.GAME__PLACES:
        return places != null && !places.isEmpty();
      case GamesPackage.GAME__KNOWLEDGE:
        return knowledge != null && !knowledge.isEmpty();
      case GamesPackage.GAME__PEOPLE:
        return people != null && !people.isEmpty();
      case GamesPackage.GAME__ITEMS:
        return items != null && !items.isEmpty();
      case GamesPackage.GAME__PATH:
        return path != null && !path.isEmpty();
      case GamesPackage.GAME__RECIPES:
        return recipes != null && !recipes.isEmpty();
      case GamesPackage.GAME__START_PLACE:
        return startPlace != null;
      case GamesPackage.GAME__END_PLACE:
        return endPlace != null && !endPlace.isEmpty();
      case GamesPackage.GAME__DIFFICULTY:
        return difficulty != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //GameImpl
