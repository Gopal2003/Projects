import React from 'react'
import { getImageUrl } from '../../utils'
import styles from "./About.module.css";

const About = () => {
    return (
        <section className={styles.container} id='about'>
            <h2 className={styles.title}>About</h2>
            <div className={styles.content}>
                <img
                    src={getImageUrl("About/AboutImage.jpg")}
                    alt="me sitting with a laptop"
                    className={styles.aboutImage}
                />
                <ul className={styles.aboutItems}>
                    <li className={styles.aboutItem}>
                        <img 
                        src={getImageUrl("About/cursorIcon.png")} alt="cursor icon" 
                        />
                        <div className={styles.aboutItemText}>
                            <h3>Frontend Developer</h3>
                            <p>I'am a frontend developer with experience in building and optimizing sites</p>
                        </div>
                    </li>

                    <li className={styles.aboutItem}>
                        <img 
                        src={getImageUrl("About/serverIcon.png")} alt="server icon" 
                        />
                        <div className={styles.aboutItemText}>
                            <h3>Backend Developer</h3>
                            <p>
                                I have experience developing fast and optimised and APIs
                            </p>
                        </div>
                    </li>

                    <li className={styles.aboutItem}>
                        <img src={getImageUrl("About/uiIcon.png")} alt="ui icon" />
                        <div className={styles.aboutItemText}>
                            <h3>UI Designer</h3>
                            <p>
                                I'am a frontend developer with experience in building and optimizing sites
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
    )
}

export default About