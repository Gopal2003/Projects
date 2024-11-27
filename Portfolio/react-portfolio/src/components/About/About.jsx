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
                            <h3>Problem Solver</h3>
                            <p>Solved more than 400 DSA Programming Question across Various Coding Platforms such as LeetCode, GeeksForGeeks and Hackerrank</p>
                        </div>
                    </li>

                    <li className={styles.aboutItem}>
                        <img
                            src={getImageUrl("About/serverIcon.png")} alt="server icon"
                        />
                        <div className={styles.aboutItemText}>
                            <h3>Knowledge Seeker</h3>
                            <p>
                                I enjoy learning and exploring new topics
                            </p>
                        </div>
                    </li>

                    <li className={styles.aboutItem}>
                        <img src={getImageUrl("About/uiIcon.png")} alt="ui icon" />
                        <div className={styles.aboutItemText}>
                            <h3>Self Learner</h3>
                            <p>
                                I am a self & quick learner who enjoys exploring topics in depth for a comprehensive understanding
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
    )
}

export default About