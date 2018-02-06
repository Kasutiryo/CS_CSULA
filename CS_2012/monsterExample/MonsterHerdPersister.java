package monsterExample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MonsterHerdPersister{
	public void saveHerdToFile(File f, MonsterHerd mh) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(f)));
			out.writeObject(mh);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public MonsterHerd readHerdFromFile(File f) {
		ObjectInputStream in = null;
		MonsterHerd m = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(f)));
			m = (MonsterHerd) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}

}

