package com.wintechs.chitraguptaapp.navdata;

import java.util.ArrayList;
import java.util.List;

public class NavMenuList {

	public List<NavMenuItem> getNavigationMenuList() {

		List<NavMenuItem> menuItems = new ArrayList<NavMenuItem>();

		menuItems.add(new NavMenuItem(0, "Hi.."));
		
		menuItems.add(new NavMenuItem(1, "History"));
		menuItems.add(new NavMenuItem(2, "Wansh"));
		menuItems.add(new NavMenuItem(3, "Pooja Vidhi"));
		menuItems.add(new NavMenuItem(4, "Aarti"));
		menuItems.add(new NavMenuItem(5, "Chalisa"));
		menuItems.add(new NavMenuItem(6, "Gallery"));
		
		menuItems.add(new NavMenuItem(7, "Settings"));
		menuItems.add(new NavMenuItem(8, "About us"));
		menuItems.add(new NavMenuItem(9, "Rate the app"));

		return menuItems;
	}

}
