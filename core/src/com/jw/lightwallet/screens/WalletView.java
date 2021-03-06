package com.jw.lightwallet.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jw.lightwallet.LightWallet;
import com.jw.lightwallet.wallet.WalletSaveRPC;

public class WalletView {
	LightWallet 	game;
	WalletSaveRPC 	walletsaverpc;

	Table			walletlayout;
	
	Label			namelabel;
	Label			namevalue;	
	TextButton		addresslabel;
	Label			addressvalue;
	Label			synclabel;
	Label			syncvalue;
	Label			unlockedlabel;
	Label			unlockedvalue;
	Label			balancelabel;
	Label			balancevalue;
	Label			calcedlabel;
	Label			calcedvalue;
	TextButton		savewalletbtn;
	Label			savewalletlabel;
	
	int 			padvalue;


	public WalletView (final LightWallet game, final WalletSaveRPC walletsaverpc) {
		this.game			= game;
		this.walletsaverpc 	= walletsaverpc;
				
		walletlayout 		= new Table();
		padvalue			= 12;

		namelabel 			= new Label("Name: ", game.uiSkin);
		namevalue			= new Label(game.walletvalues.getName(), game.uiSkin);
		walletlayout.add(namelabel).pad(padvalue);
		walletlayout.add(namevalue).pad(padvalue).row();
		
		addresslabel 		= new TextButton("Address (click to copy): ", game.uiSkin);
		addressvalue		= new Label(game.walletvalues.getAddress(), game.uiSkin);
		addressvalue.setFontScale(0.6f, 0.6f);
		walletlayout.add(addresslabel).pad(padvalue);
		walletlayout.add(addressvalue).pad(padvalue).row();
		
		synclabel 			= new Label("Wallet sync: ", game.uiSkin);
		syncvalue			= new Label("0 / A lot", game.uiSkin, "redlabel");
		walletlayout.add(synclabel).pad(padvalue);
		walletlayout.add(syncvalue).pad(padvalue).row();
		
		unlockedlabel 		= new Label("Unlocked balance: ", game.uiSkin);
		unlockedvalue		= new Label("Loading...", game.uiSkin, "redlabel");
		walletlayout.add(unlockedlabel).pad(padvalue);
		walletlayout.add(unlockedvalue).pad(padvalue).row();
		
		balancelabel 		= new Label("Balance: ", game.uiSkin);
		balancevalue			= new Label("Loading...", game.uiSkin, "redlabel");
		walletlayout.add(balancelabel).pad(padvalue);
		walletlayout.add(balancevalue).pad(padvalue).row();
		
		calcedlabel 		= new Label("Calculated balance: ", game.uiSkin);
		calcedvalue			= new Label("None", game.uiSkin);
		walletlayout.add(calcedlabel).pad(padvalue);
		walletlayout.add(calcedvalue).pad(padvalue).row();		
		
		savewalletbtn		= new TextButton("Save (attempts autosave every 60 s)", game.uiSkin);
		savewalletlabel		= new Label("Not saved :(", game.uiSkin, "redlabel");
		walletlayout.add(savewalletbtn);
		walletlayout.add(savewalletlabel);
		
		walletlayout.add(new Label("", game.uiSkin)).fill().expand();

		savewalletbtn.addListener(new ClickListener() {
	        @Override
	        public void clicked (InputEvent event, float x, float y) {
	        	walletsaverpc.trysave(savewalletlabel);
	        }
	    });	
		
		addresslabel.addListener(new ClickListener() {
	        @Override
	        public void clicked (InputEvent event, float x, float y) {
	        	Gdx.app.getClipboard().setContents(game.walletvalues.getAddress());
	        }
	    });	
		
	}


	public Label getSavewalletlabel() {
		return savewalletlabel;
	}


	public void setSavewalletlabel(Label savewalletlabel) {
		this.savewalletlabel = savewalletlabel;
	}
}
