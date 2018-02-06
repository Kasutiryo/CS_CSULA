package monsterExample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MonsterHerd implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Monster> monsters = new ArrayList<Monster>();
		
	public List<Monster> getMonsters() {
		return monsters;
	}	
	
	public void addMonster(Monster m){monsters.add(m);}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Monster m: monsters) sb.append(m + "\n");
		return sb.toString();		
	}
}

