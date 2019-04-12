// ----- ----- Class 1: Stdio ----- -----

package include;

import com.mtsystems.coot.NativeHelper;
import com.mtsystems.coot.String8;
import com.sun.jna.Library;

public class Stdio {
    private static interface IndirectMappings extends Library {
        int scanf(String8 format, Object... varargs);
    }

    private final static IndirectMappings INDIRECT_MAPPINGS;

    static {
        // The online demo uses the example library "libc.so.6".
        // Have a look at the translated programs for real values.
        NativeHelper h = NativeHelper.get("libc.so.6");
        INDIRECT_MAPPINGS = h.bindIndirect(IndirectMappings.class);
    }

    /**
     * Read formatted input from stdin.
     */
    public static int scanf(String8 format, Object... varargs) {
        return INDIRECT_MAPPINGS.scanf(format, varargs);
    }
}


// ----- ----- Class 2: DemoTranslation ----- -----

package demo;

        import static com.mtsystems.coot.String8.cs8;
        import static include.Stdio.scanf;

        import com.mtsystems.coot.FloatContainer;

public class DemoTranslation {
    public static void main(String[] args) {
		/*
  You can write C code here or look at the examples.
  It will be translated as "demo/demo_translation.c".
  There are also translations of full programs below.
*/
        float sleepave, addsleep, lesssleep;
        FloatContainer msleep = new FloatContainer(1), tsleep = new FloatContainer(1), wsleep = new FloatContainer(1), hsleep = new FloatContainer(1), fsleep = new FloatContainer(1), sasleep = new FloatContainer(1), susleep = new FloatContainer(1);
        {
            System.out.print("Number of Hours Slept:");
            System.out.print("\nMonday");
            scanf(cs8("%i"), msleep);
            System.out.print("\nTuesday");
            scanf(cs8("%i"), tsleep);
            System.out.print("\nWednesday");
            scanf(cs8("%i"), wsleep);
            System.out.print("\nThursday");
            scanf(cs8("%i"), hsleep);
            System.out.print("\nFriday");
            scanf(cs8("%i"), fsleep);
            System.out.print("\nSaturday");
            scanf(cs8("%i"), sasleep);
            System.out.print("\nSunday");
            scanf(cs8("%i"), susleep);
            sleepave = (msleep.get() + tsleep.get() + wsleep.get() + hsleep.get() + fsleep.get() + sasleep.get() + susleep.get()) / 7;
        }
    }
}