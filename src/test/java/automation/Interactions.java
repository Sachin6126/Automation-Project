package automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import interactions.Dragabble;
import interactions.Droppable;
import interactions.Resizable;
import interactions.Selectable;
import interactions.Sortable;

public class Interactions extends Base {
	String author = "Sharma";
	WebDriver driver;

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initBrowser();
		driver.get(url + "interaction");
	}

	@Test
	public void verifySortable() {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).perform();
		Sortable sort = new Sortable(driver);
		sort.clickSortable().click();

		sort.gridTab().click();
		mouse.dragAndDrop(sort.gridSort("One"), sort.gridSort("Six")).perform();
		mouse.dragAndDrop(sort.gridSort("Two"), sort.gridSort("Five")).perform();
		mouse.dragAndDrop(sort.gridSort("Four"), sort.gridSort("Seven")).perform();

		sort.tabList().click();
		mouse.dragAndDrop(sort.listSort("One"), sort.listSort("Two")).perform();
		mouse.dragAndDrop(sort.listSort("Five"), sort.listSort("Three")).perform();
		mouse.dragAndDrop(sort.listSort("Two"), sort.listSort("Four")).perform();
	}

	@Test
	public void verifySelectable() {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).perform();
		Selectable select = new Selectable(driver);
		select.clickSelectable().click();

		select.gridTab().click();
		for (int i = 0; i < select.gridSelect().size(); i++) {
			select.gridSelect().get(i).click();
		}

		select.tabList().click();
		for (int i = 0; i < select.listSelect().size(); i++) {
			select.listSelect().get(i).click();
		}
	}

	@Test
	public void verifyResizable() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).perform();
		Resizable resize = new Resizable(driver);
		resize.clickResizable().click();
		Thread.sleep(500);
		mouse.dragAndDropBy(resize.limitedResizabe(), 50, 50).perform();
		mouse.scrollByAmount(0, 500).perform();
		mouse.dragAndDropBy(resize.freeResizabe(), 100, 100).perform();
	}

	@Test
	public void verifyDroppable() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).perform();
		Droppable drop = new Droppable(driver);
		drop.clickDroppable().click();
		Thread.sleep(500);
		mouse.clickAndHold(drop.dragMe()).moveToElement(drop.dropHere()).release().perform();
		String text = drop.verifyDrophere().getText();
		Assert.assertEquals(text, "Dropped!");

		drop.acceptTab().click();
		mouse.clickAndHold(drop.acceptableDrag()).moveToElement(drop.acceptDropHere()).release().perform();
		text = drop.verifyAcceptDrophere().getText();
		Assert.assertEquals(text, "Dropped!");
		mouse.clickAndHold(drop.notAcceptableDrag()).moveToElement(drop.acceptDropHere()).release().perform();

		drop.preventPropagationTab().click();
		mouse.scrollByAmount(0, 500).perform();
		mouse.clickAndHold(drop.dragBox()).moveToElement(drop.outerDroppable()).release().perform();
		mouse.clickAndHold(drop.dragBox()).moveToElement(drop.innerDroppable()).release().perform();
		mouse.clickAndHold(drop.dragBox()).moveToElement(drop.greedyOuterDroppable()).release().perform();
		mouse.clickAndHold(drop.dragBox()).moveToElement(drop.greedyInnerDroppable()).release().perform();

		drop.revertDraggableTab().click();
		mouse.clickAndHold(drop.revertable()).moveToElement(drop.verifyRevertDrop()).release().perform();
		mouse.clickAndHold(drop.notRevertable()).moveToElement(drop.verifyRevertDrop()).release().perform();
	}

	@Test
	public void verifyDragable() throws InterruptedException {
		Actions mouse = new Actions(driver);
		mouse.scrollByAmount(0, 500).perform();
		Dragabble drag = new Dragabble(driver);
		drag.clickDragable().click();
		Thread.sleep(500);

		mouse.clickAndHold(drag.dragMe()).moveByOffset(150, 100).release().perform();

		drag.axisRestrictTab().click();
		mouse.clickAndHold(drag.restrictedX()).moveByOffset(200, 0).release().perform();
		mouse.clickAndHold(drag.restrictedY()).moveByOffset(0, 200).release().perform();

		drag.containerRestrictedTab().click();
		mouse.clickAndHold(drag.withinBox()).moveByOffset(300, 100).release().perform();
		mouse.clickAndHold(drag.textWithinBox()).moveByOffset(0, 10).release().perform();

		drag.cursorStyleTab().click();
		mouse.clickAndHold(drag.StickCenter()).moveByOffset(200, 0).release().perform();
		mouse.clickAndHold(drag.stickTopLeft()).moveByOffset(200, 0).release().perform();
		mouse.clickAndHold(drag.stickBottom()).moveByOffset(200, 0).release().perform();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}