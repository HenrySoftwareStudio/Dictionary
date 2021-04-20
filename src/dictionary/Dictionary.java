/**
 * 
 */
package dictionary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author also me
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class Dictionary<KeyType,ValueType> 
{
	private ArrayList<KeyType> Keys;
	private ArrayList<ValueType> Values;
	
	
	/**
	 * @throws IllegalArgumentException if InitKey's length does not equal to InitValues'
	 * 
	 * @param InitKeys
	 * @param InitValues
	 */
	public Dictionary(KeyType[] InitKeys, ValueType[] InitValues)
	{
		if(InitKeys.length!=InitValues.length)
		{
			throw new IllegalArgumentException("InitKeys Parameter's Length is NOT the same as InitValue Parameter's, This is NOT Allowed");
		}
		this.Keys=new ArrayList<>(Arrays.asList(InitKeys));
		this.Values=new ArrayList<>(Arrays.asList(InitValues));
		
	}
	
	/**default constructor
	 * 
	 */
	public Dictionary()
	{
		this.Keys=new ArrayList<>();
		this.Values=new ArrayList<>();
	}
	
	/**
	 * @throws IllegalArgumentException if either key or value is null
	 * @throws IllegalArgumentException if the key to add is already in this instance of Dictionary
	 * 
	 * @param Key
	 * @param Value
	 */
	public void Add(KeyType Key,ValueType Value)
	{
		if ((Key == null) | (Value == null))
		{
			String ToSay=((Keys == null)? "Key or Both are null": "Value is null")+" is NOT Allowed";
			throw new IllegalArgumentException(ToSay);
		}
		if(this.IsPresentInKey(Key))
		{
			throw new IllegalArgumentException("the key is already present, would you like to use [Instance of Dictionary Name].Change(KeyType Key,ValueType NewValue) instead?");
		}
		this.Keys.add(Key);
		this.Values.add(Value);
	}
	
	/**
	 * @throws IllegalArgumentException if Key parameter does not exist in this instance of Dictionary
	 * @throws IllegalArgumentException if NewValue is null
	 * 
	 * @param Key
	 * @param NewValue
	 */
	public void Change(KeyType Key,ValueType NewValue)
	{
		if(!IsPresentInKey(Key))
		{
			throw new IllegalArgumentException("key"+Key+"does not exist in this Dictionary");
		}
		if(NewValue == null)
		{
			throw new IllegalArgumentException("NewValue Parameter Can NOT Be Null");
		}
		final int Index=this.Keys.indexOf(Key);
		this.Values.remove(Index);
		this.Values.add(Index, NewValue);
	}
	
	/**
	 * @throws IllegalArgumentException if Key does not exist in this instance of Dictionary
	 * 
	 * @param Key
	 * @return Value at the key
	 */
	public ValueType GetByKey(KeyType Key)
	{
		if(!IsPresentInKey(Key))
		{
			throw new IllegalArgumentException("key"+Key+"does not exist in this Dictionary");
		}
		final int FoundAtIndex=this.Keys.indexOf(Key);
		return this.Values.get(FoundAtIndex);
	}
	
	/**
	 * 
	 * @return length of the Dictionary
	 */
	public int Length()
	{
		return (this.Keys.size()+this.Values.size())/2;
	}
	
	/**
	 * @throws IllegalArgumentException if Key does not exist in this instance of Dictionary
	 * 
	 * @param Key
	 */
	public void RemoveByKey(KeyType Key)
	{
		if(!IsPresentInKey(Key))
		{
			throw new IllegalArgumentException("key"+Key+"does not exist in this Dictionary");
		}
		final int IndexToBeRemoved=this.Keys.indexOf(Key);
		this.Keys.remove(IndexToBeRemoved);
		this.Values.remove(IndexToBeRemoved);
	}
	
	/**
	 * 
	 * @param Key
	 * @return True if key is present in this instance of Dictionary
	 */
	public boolean IsPresentInKey(KeyType Key)
	{
		return this.Keys.contains(Key);
	}

}