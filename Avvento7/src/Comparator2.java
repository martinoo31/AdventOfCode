import java.util.Comparator;
import java.util.Vector;

public class Comparator2 implements Comparator {

	// a negative integer, zero, or a positive integer as the first argument
	// is less than, equal to, or greater than the second.
	@Override
	public int compare(Object o1, Object o2) {
		String[] cardsList = { "J", "2", "3", "4", "5", "6", "7", "8", "9", "T", "Q", "K", "A" };
		Vector<Vector<Integer>> valueFirst = new Vector<Vector<Integer>>();
		Vector<Vector<Integer>> valueSecond = new Vector<Vector<Integer>>();
		for (int i = 0; i < 5; i++) {
			valueFirst.add(new Vector<Integer>());
			valueSecond.add(new Vector<Integer>());
		}
		Hand h1 = (Hand) o1;
		Hand h2 = (Hand) o2;
		String cardsFirst = h1.cards;
		String cardsSecond = h2.cards;
		int jFirst = 0;
		int jSecond = 0;
		for (int i = 0; i < cardsList.length; i++) {

			String temp = cardsList[i];
			String mod = cardsFirst.replace(temp, "");
			int difference = cardsFirst.length() - mod.length();
			if (i == 0 && difference > 0) {
				jFirst = difference;
				cardsFirst = mod;
				continue;
			}
			if (difference == 0)
				continue;
			valueFirst.get(difference - 1).add(i);
			cardsFirst = mod;
			if (cardsFirst.isEmpty())
				break;
		}

		for (int i = 0; i < cardsList.length; i++) {
			String temp = cardsList[i];
			String mod = cardsSecond.replace(temp, "");
			int difference = cardsSecond.length() - mod.length();
			if (i == 0 && difference > 0) {
				jSecond = difference;
				cardsSecond = mod;
				continue;
			}
			if (difference == 0)
				continue;
			valueSecond.get(difference - 1).add(i);
			cardsSecond = mod;
			if (cardsSecond.isEmpty())
				break;
		}

		valueFirst.get(1).sort(null);
		valueFirst.get(0).sort(null);

		valueSecond.get(1).sort(null);
		valueSecond.get(1).sort(null);
		if (jFirst == 5) {
			valueFirst.get(4).add(0);
		} else {
			for (int i = 3; i >= 0; i--) {
				if (valueFirst.get(i).size() > 0) {
					valueFirst.get(i + jFirst).add(valueFirst.get(i).get(0));
					valueFirst.get(i).remove(0);
					break;
				}
			}
		}

		if (jSecond == 5) {
			valueSecond.get(4).add(0);
		} else {
			for (int i = 3; i >= 0; i--) {
				if (valueSecond.get(i).size() > 0) {
					valueSecond.get(i + jSecond).add(valueSecond.get(i).get(0));
					valueSecond.get(i).remove(0);
					break;
				}
			}

		}

		for (int i = 4; i >= 0; i--) {
			if (valueFirst.get(i).size() == valueSecond.get(i).size()) {
				if (valueFirst.get(i).size() == 0)
					continue;
				if (i == 2) {
					if (valueFirst.get(1).size() > valueSecond.get(1).size()) {
						return 1;
					} else if (valueFirst.get(1).size() < valueSecond.get(1).size()) {
						return -1;
					}
				}
				for (int j = 0; j < 5; j++) {
					char f, s;
					f = h1.cards.charAt(j);
					s = h2.cards.charAt(j);
					if (f != s) {
						Integer fInt = 0;
						Integer sInt = 0;
						for (int k = 0; k < cardsList.length; k++) {
							if (cardsList[k].equals("" + f))
								fInt = k;
							if (cardsList[k].equals("" + s))
								sInt = k;
						}
						return fInt.compareTo(sInt);
					}
				}
			} else if (valueFirst.get(i).size() > valueSecond.get(i).size()) {
				return 1;
			} else if (valueFirst.get(i).size() < valueSecond.get(i).size()) {
				return -1;
			}
		}
		return 0;

	}

}
