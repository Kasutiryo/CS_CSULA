package attacks;

import java.io.File;
import java.util.List;

public interface MonsterPersister {

	public void save(File f, List<MonsterAttack> monsters);

	public List<MonsterAttack> load(File f);
}
