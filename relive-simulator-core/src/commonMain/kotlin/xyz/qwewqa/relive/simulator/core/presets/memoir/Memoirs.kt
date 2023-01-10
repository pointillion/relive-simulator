package xyz.qwewqa.relive.simulator.core.presets.memoir

val memoirs = mapOf("None" to EmptyMemoir) + (
        listOf(
            UnshakableFeelings,
            FriendsAtTheAquarium,
            UrashimaTaroPerformanceFlyer,
            CoStarringWithHatsuneMiku,
            FirstAnnivSeishoMusicAcademy,
            FirstAnnivSiegfeldInstituteOfMusic,
            FirstAnnivRinmeikanGirlsSchool,
            FirstAnnivFrontierSchoolOfArts,
            BlessedDawn,
            BandsmansGreeting,
            KeepersOfThePeace,
            CrazyMadScientist,
            SunnyLunchtime,
            ToTheWonderfulWorldOfRakugo,
            ThePhantomAndChristine,
            PoolsideIncident,
            MerryChristmas2019,
            CherryBlossomsInTheBento,
            PrinceAndPrincessEtude,
            StarOfTheDay,
            WrongStarOfTheDay,
            SunsetLabMemBadge,
            ReminiscenceMelody,
            KappoTomoyesPosterGirl,
            UnburnedFlowerUnwitheredFlame,
            XIIHangedManReverse,
            VILoversReverse,
            XVITowerUpright,
            XVITowerReverse,
            PrideOfARoseRespectVer,
            TheGreatYearEndCleanup,
            ConfidantsOnADate,
            SparklingStageChika,
            StretchingHelp,
            ReverberatingVoiceTsubasaMaya,
            ChinatownDelicacies,
            DeuxJunoJuneBride,
            EnjoyingWinter,
            TurbulentNinja,
            ADayInTheGodessesLife,
            CleaningTogether,
            RareCoStar,
            OneForAll,
            StarOfTheDayFutabaKaoruko,
            AimToUnifyTheWorld,
            ForTheShinsengumi,
            ShinsengumiRinpuden,
            StarOfTheDayMaHiKaren,
            ForOurSpecialPlace,
            XXJudgementUpright,
            IIPriestessReverse,
            XXIVCharityUpright,
            XIStrengthUpright,
            XXIIIHopeUpright,
            XXJudgementReverse,
            XXIWorldUpright,
            XXIWorldReverse,
            Carmen,
            WatchingMoviesAtTheater,
            SurroundedByNature,
            NostalgicRyoko,
            RevueOfFateAndTruth,
            TwoRevues,
            YachiyosFashionTips,
            FestivalKaren,
            MatchingCardigan,
            MyOwnStage,
            RipeTomato,
            JesterontheStageoftheGods,
            SingDanceandBattle,
            The101stSeishoFestivalRally,
            ToStandOnAnyStage,
            MeiFansFortuneTelling,
            DevilsBargain,
            RoommatesHelp,
            BrillianceEveryDayClaudineMaya,
            BrillianceEveryDayJunnaNana,
            BrillianceEveryDayFutabaKaoruko,
        ).sortedBy { it.name }.sortedBy { it.cutinData == null }
                + oneSpecialDays
                + brilliantBirthdays
                + slapMemos
                + positionZeros
        ).associateBy { it.name }
