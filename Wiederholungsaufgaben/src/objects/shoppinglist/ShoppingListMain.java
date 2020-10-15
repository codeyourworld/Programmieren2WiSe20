package objects.shoppinglist;

public class ShoppingListMain {

	public static void main(String[] args) {
		ShoppingList shoppingList = new ShoppingList();
		for(int i = 0; i < 90; i ++) {
			System.out.println(shoppingList.getCurrentProducts());
			shoppingList.nextDay();
		}
	}

}
