package com.jw.lightwallet.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.jw.lightwallet.LightWallet;
import com.jw.lightwallet.utils.DaemonValues;

import java.text.DecimalFormat;

public class DaemonView {
	
	LightWallet game;
	
	Skin 		uiSkin;
	
	Table		daemonlayout;
	
	Label		nodelabel;
	Label		nodevalue;
	Label		statuslabel;
	Label		statusvalue;
	Label		heightlabel;
	Label		heightvalue;
	Label		hashratelabel;
	Label		hashratevalue;
	Label		timelabel;
	Label		timevalue;
	Label		rewardlabel;
	Label		rewardvalue;
	
	int 		padvalue;


	public DaemonView (final LightWallet game) {
	
	this.game		= game;
		
	uiSkin 			= new Skin(Gdx.files.internal("skin/uiskin.json"));
		
	daemonlayout 	= new Table();
	padvalue		= 15;

	
	nodelabel 		= new Label("Node address: ", uiSkin);
	nodevalue		= new Label(null, uiSkin);
	daemonlayout.add(nodelabel).pad(padvalue);
	daemonlayout.add(nodevalue).pad(padvalue).row();
	
	statuslabel 	= new Label("Node status: ", uiSkin);
	statusvalue		= new Label(null, uiSkin);
	daemonlayout.add(statuslabel).pad(padvalue);
	daemonlayout.add(statusvalue).pad(padvalue).row();
	
	heightlabel 	= new Label("Block height: ", uiSkin);
	heightvalue		= new Label(null, uiSkin);
	daemonlayout.add(heightlabel).pad(padvalue);
	daemonlayout.add(heightvalue).pad(padvalue).row();
	
	hashratelabel 	= new Label("Network hashrate: ", uiSkin);
	hashratevalue	= new Label(null, uiSkin);
	daemonlayout.add(hashratelabel).pad(padvalue);
	daemonlayout.add(hashratevalue).pad(padvalue).row();
	
	timelabel 		= new Label("Last block time: ", uiSkin);
	timevalue		= new Label(null, uiSkin);
	daemonlayout.add(timelabel).pad(padvalue);
	daemonlayout.add(timevalue).pad(padvalue).row();
	
	rewardlabel 	= new Label("Last reward: ", uiSkin);
	rewardvalue		= new Label(null, uiSkin);
	daemonlayout.add(rewardlabel).pad(padvalue);
	daemonlayout.add(rewardvalue).pad(padvalue).row();
	
	daemonlayout.add(new Label("", uiSkin)).fill().expand();
	}
	
	public void Update(DaemonValues daemonvalues) {
		nodevalue.setText(game.walletvalues.getNode());
		statusvalue.setText(daemonvalues.getStatus());
		Gdx.app.log(LightWallet.LOG, "Status value is: " + statusvalue.getText());
		if (statusvalue.getText().toString().equals("OK")) {statusvalue.setStyle(uiSkin.get("greenlabel", LabelStyle.class));}
		heightvalue.setText(String.valueOf(daemonvalues.getBlockheight()));
		hashratevalue.setText(new DecimalFormat("##.##").format(daemonvalues.getHashrate()) + " Mh/s");
		timevalue.setText(String.valueOf(new java.util.Date(daemonvalues.getLastblocktime()*1000)));
		rewardvalue.setText(new DecimalFormat("##.##").format(daemonvalues.getLastblockreward()/1e12) + " XMR");
	}

}
