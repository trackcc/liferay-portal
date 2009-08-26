/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portalweb.portal.controlpanel.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="MoveThreadTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class MoveThreadTest extends BaseTestCase {
	public void testMoveThread() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Message Boards")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace("link=Message Boards"));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace("//tr[4]/td[1]/a[1]/b"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("//li[5]/span/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace("//b"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("//li[6]/span/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace("//b"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("//li[7]/span/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace(
						"link=T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("//li[8]/span/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertTrue(selenium.isTextPresent(
						"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"));
				selenium.click(RuntimeVariables.replace("link=Move Thread"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("//li[9]/span/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click("_19_addExplanationPost");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("_19_subject")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.typeKeys("_19_subject",
					RuntimeVariables.replace("Moved to Sujr"));
				selenium.type("_19_subject",
					RuntimeVariables.replace("Moved to Sujr"));
				selenium.type("_19_textArea",
					RuntimeVariables.replace(
						"Trust and paths will be straightened."));
				selenium.click("//input[@value='Select']");
				selenium.waitForPopUp("category",
					RuntimeVariables.replace("30000"));
				selenium.selectWindow("category");
				Thread.sleep(5000);

				boolean CategoriesPresent = selenium.isElementPresent(
						"link=Categories");

				if (!CategoriesPresent) {
					label = 2;

					continue;
				}

				selenium.click(RuntimeVariables.replace("link=Categories"));
				selenium.waitForPageToLoad("30000");

			case 2:
				selenium.click("//input[@value='Choose']");
				selenium.selectWindow("null");
				Thread.sleep(5000);
				assertTrue(selenium.isElementPresent("link=Sujr"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value=\"Move Thread\"]"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent("link=Sujr"));
				assertTrue(selenium.isElementPresent(
						"link=T\u00e9st M\u00e9ssag\u00e9 to b\u00e9 D\u00e9l\u00e9t\u00e9d"));
				assertTrue(selenium.isTextPresent(
						"This m\u00e9ssag\u00e9 will b\u00e9 d\u00e9l\u00e9t\u00e9d!"));
				assertTrue(selenium.isTextPresent(
						"Trust and paths will be straightened."));
				assertFalse(selenium.isElementPresent(
						"link=T\u00e9st Subcat\u00e9gory"));
				assertFalse(selenium.isElementPresent(
						"link=T\u00e9st Cat\u00e9gory"));

			case 100:
				label = -1;
			}
		}
	}
}