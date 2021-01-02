package business.services.util;

import business.abstracts.MusicPlayer;
import business.interfaces.TrackChange;

public enum SkipState implements TrackChange {

	DEFAULT {

		@Override
		public void skip(MusicPlayer player) {
			if (player.getPlaylist().hasNext())
				player.play(player.getPlaylist().next());
		}

		@Override
		public void skipBack(MusicPlayer player) {
			if (player.getPlaylist().hasPrev())
				player.play(player.getPlaylist().prev());
		}
	},

	ALL {

		@Override
		public void skip(MusicPlayer player) {
			player.play(player.getPlaylist().next());
			
		}

		@Override
		public void skipBack(MusicPlayer player) {
			player.play(player.getPlaylist().prev());
		}
	},

	SINGLE {

		@Override
		public void skip(MusicPlayer player) {
			player.play(player.getPlaylist().current());
			
		}

		@Override
		public void skipBack(MusicPlayer player) {
			player.play(player.getPlaylist().current());
		}
	},
	
	SHUFFLE {

		@Override
		public void skip(MusicPlayer player) {
			player.play(player.getPlaylist().random());
		}

		@Override
		public void skipBack(MusicPlayer player) {
			player.play(player.getPlaylist().random());
		}		
		
	};
	
	public abstract void skip(MusicPlayer player);
	public abstract void skipBack(MusicPlayer player);

}
