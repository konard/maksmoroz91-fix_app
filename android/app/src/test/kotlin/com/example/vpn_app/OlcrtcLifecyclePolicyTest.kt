package com.example.vpn_app

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OlcrtcLifecyclePolicyTest {
    @Test
    fun flutterEngineDetachKeepsNativeTunnelRunning() {
        assertFalse(
            OlcrtcLifecyclePolicy.shouldStopNative(OlcrtcStopReason.FlutterEngineDetached)
        )
    }

    @Test
    fun explicitTeardownStopsNativeTunnel() {
        assertTrue(OlcrtcLifecyclePolicy.shouldStopNative(OlcrtcStopReason.UserRequest))
        assertTrue(OlcrtcLifecyclePolicy.shouldStopNative(OlcrtcStopReason.VpnServiceStopped))
        assertTrue(OlcrtcLifecyclePolicy.shouldStopNative(OlcrtcStopReason.VpnRevoked))
    }
}
