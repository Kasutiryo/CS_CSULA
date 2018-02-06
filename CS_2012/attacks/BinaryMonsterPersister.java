package attacks;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class BinaryMonsterPersister implements MonsterPersister {

	public void save(File f, List<MonsterAttack> monsters) {
		
		ObjectOutputStream out = null;
		
		try {
			
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			
			out.writeObject(monsters);
			
			out.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<MonsterAttack> load(File f) {
		
		ObjectInputStream in = null;
		
		List<MonsterAttack> monsters = null;
		
		try {
			
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			
			monsters = (List<MonsterAttack>) in.readObject();
			
			in.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return monsters;

	}
}
