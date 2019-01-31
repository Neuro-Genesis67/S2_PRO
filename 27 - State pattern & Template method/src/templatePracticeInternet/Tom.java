package templatePracticeInternet;

public class Tom extends Internet {

	@Override
	void InitialResponse() {
		System.out.println("Tom asks the first responsible adult he sees, if the internet is down");
	}

	@Override
	void Action() {
		System.out.println(
				"Goes into nature and climbs a tree, he does not need internet, for he realizes that he is a caveman");
	}

	@Override
	void Hook() {
		System.out.println(
				"Falls down the tree, breaks his neck and lies in agony for 62 hours before dying of dehydration");
	}

}
