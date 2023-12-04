import java.util.Objects;

public class Coppia {
	public int x;
	public int y;
	
	public Coppia(int x,int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coppia other = (Coppia) obj;
		return x == other.x && y == other.y;
	}
	
	
	
}
