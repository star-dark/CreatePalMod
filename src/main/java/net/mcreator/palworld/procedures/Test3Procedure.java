package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class Test3Procedure {
	public static void execute(HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:textFieldName") instanceof EditBox _tf)
			_tf.setValue("Text");
	}
}
