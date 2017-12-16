package avalon.group

import avalon.extend.Hitokoto
import avalon.util.GroupConfig
import avalon.util.GroupMessage
import java.util.regex.Pattern

object Hitokoto : GroupMessageResponder() {
	override fun doPost(message: GroupMessage, groupConfig: GroupConfig) {
		message.response(Hitokoto.get())
	}

	override fun responderInfo(): ResponderInfo =
			ResponderInfo(
					Pair("avalon (hitokoto|一言)", "获取一条一言。"),
					Pattern.compile("^avalon (hitokoto|一言)")
			)

	override fun instance() = this
}