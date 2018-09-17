package net.mf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;
import com.hp.lft.sdk.mobile.*;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, InterruptedException {
        /*DeviceInfo deviceInfo[] = MobileLab.getDeviceList();

        System.out.println (deviceInfo[0].getName());
*/
        // select device and app
        // you will need to provide the device ID which is availalbe in your Mobile Center installation.
        Device device = MobileLab.lockDeviceById("ce031713bc66a70d05");
        Application app = device.describe(Application.class, new ApplicationDescription.Builder().identifier("com.Advantage.aShopping").build());
        app.restart();

        // start Login
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").resourceId("imageViewMenu").mobileCenterIndex(0).build()).tap();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("LOGIN").className("Label").resourceId("textViewMenuUser").mobileCenterIndex(9).build()).highlight();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("LOGIN").className("Label").resourceId("textViewMenuUser").mobileCenterIndex(9).build()).tap();

        // highlight field first (not mandatory)
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(0).build()).highlight();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(0).build()).tap();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(0).build()).setText("Shahar");

        // highlight field first (not mandatory)
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(1).build()).highlight();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(1).build()).tap();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(EditField.class, new EditFieldDescription.Builder()
                .className("Input").mobileCenterIndex(1).build()).setSecure("5954194bd5c6399c6cd6ceb9978eb34043372b53e9413311");

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("LOGIN").className("Button").resourceId("buttonLogin").mobileCenterIndex(0).build()).highlight();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("LOGIN").className("Button").resourceId("buttonLogin").mobileCenterIndex(0).build()).tap();
        // end login


        // select laptops
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("LAPTOPS").className("Label").resourceId("textViewCategory").mobileCenterIndex(2).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("LAPTOPS").className("Label").resourceId("textViewCategory").mobileCenterIndex(2).build()).tap();

        // pick a laptop
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").container("Table[0][2][0]").resourceId("imageViewProduct").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").container("Table[0][2][0]").resourceId("imageViewProduct").mobileCenterIndex(0).build()).tap();

        // add to cart
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("ADD TO CART").className("Button").resourceId("buttonProductAddToCart").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("ADD TO CART").className("Button").resourceId("buttonProductAddToCart").mobileCenterIndex(0).build()).tap();

        // go to cart
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("1").className("Label").resourceId("textViewCartLength").mobileCenterIndex(1).build()).tap();

        // check out
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("CHECKOUT (PAY $849.99)").className("Button").resourceId("buttonCheckOut").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("CHECKOUT (PAY $849.99)").className("Button").resourceId("buttonCheckOut").mobileCenterIndex(0).build()).tap();

        // Pay
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("PAY NOW").className("Button").resourceId("buttonPayNow").mobileCenterIndex(0).build()).tap();

        windowSync();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").resourceId("imageViewCloseDialog").mobileCenterIndex(1).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").resourceId("imageViewCloseDialog").mobileCenterIndex(1).build()).tap();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").resourceId("imageViewMenu").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                .className("ImageView").resourceId("imageViewMenu").mobileCenterIndex(0).build()).tap();

        // sign out
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("SIGN OUT").className("Label").resourceId("textViewMenuSignOut").mobileCenterIndex(10).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Label.class, new LabelDescription.Builder()
                .text("SIGN OUT").className("Label").resourceId("textViewMenuSignOut").mobileCenterIndex(10).build()).tap();

        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("YES").className("Button").resourceId("button2").mobileCenterIndex(1).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(true).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("YES").className("Button").resourceId("button2").mobileCenterIndex(1).build()).tap();

    }

    private void windowSync() throws InterruptedException {

        Thread.sleep(2000);
    }

}